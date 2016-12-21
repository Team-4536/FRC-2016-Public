package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.Profile;
import org.usfirst.frc.team4536.robot.Utilities;
import java.util.ArrayList;

/**
 *@author Audrey
 *This command is for the rectangle profile
 */
public class DriveProfile extends CommandBase {

	private final Profile profile;
	private final Timer timer = new Timer();
	private double desiredAngle = 0.0;
	private double startingAngle = 0.0;
	private boolean fieldAngle = true;
	private double accumulatedLeftDistanceError = 0.0;
	private double accumulatedRightDistanceError = 0.0;
	private double accumulatedAngleError = 0.0;
	
	//Correction Constants
	private double turnProportionality = Constants.TURNING_TRAPEOID_GYRO_PROPORTIONALITY; //TODO change constant
	private double turnIntegral = Constants.TURNING_TRAPEZOID_INTEGRAL;
	private double driveProportionality = Constants.TRAPEZOID_FORWARD_PROPORTIONALITY;
	private double driveIntegral = Constants.TRAPEZOID_INTEGRAL;
	
	//Thresholds
	private double distanceThreshold = Constants.TRAPEZOID_DISTANCE_THRESHOLD;
	private double velocityThreshold = Constants.TRAPEZOID_SPEED_THRESHOLD;
	private double angleThreshold = Constants.TRAPEZOID_ANGLE_THRESHOLD;
	private double angularVelocityThreshold = Constants.TRAPEZOID_ANGULAR_SPEED_THRESHOLD;
	private double timeOutOffset = Constants.TRAPEZOID_PROFILE_TIMEOUT_OFFSET;
    
    public DriveProfile(Profile profile) {
    	
    	requires(driveTrain);
    	this.profile = profile;
    }
    
    public DriveProfile(Profile profile, double angle) {
    	
    	this(profile);
    	desiredAngle = angle;
    	fieldAngle = false;
    }
    
    public DriveProfile(Profile profile, double angle, double turnProportionality) {
    	
    	this(profile, angle);
    	this.turnProportionality = turnProportionality;
    }
    
    /**
     * @author Audrey
     * @return time in seconds since the command was started
     */
    public double getTime() {
    	
    	return timer.get();
    }
    
    /**
     * @author Audrey
     * @return time needed from the trapezoid profile method in seconds
     */
    public double getNeededTime(){
    	
    	return profile.getTimeNeeded();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	timer.reset();
    	timer.start();
    	
    	accumulatedLeftDistanceError = 0.0;
    	accumulatedRightDistanceError = 0.0;
    	accumulatedAngleError = 0.0;
    	
    	driveTrain.resetEncoders();
    	
    	if (fieldAngle) {
    		
    		desiredAngle = driveTrain.getAngle();
    	}
    	
    	startingAngle = driveTrain.getAngle();
    	double angleDiff = Utilities.angleDifference(startingAngle, desiredAngle);
    	profile.setAngle(angleDiff);
    	
    	System.out.println("Desired Angle: " + desiredAngle);
    	System.out.println("Starting Angle: " + startingAngle);
    	System.out.println("Angle Difference: " + angleDiff);

    	setTimeout(profile.getTimeNeeded() + timeOutOffset);
    }
    
    /**
     * @author Audrey
     * @return the error in the distance between where the robot is and where it should be in inches.
     */
    public double getLeftDistanceError() {
    	
    	double leftError = profile.idealLeftDistance(timer.get()) - driveTrain.getLeftEncoder();
    	
    	return leftError;
    }
    
    /**
     * @author Audrey
     * @return the error in the distance between where the robot is and where it should be in inches.
     */
    public double getRightDistanceError() {
    	
    	double rightError = profile.idealRightDistance(timer.get()) - driveTrain.getRightEncoder();
    	
    	return rightError;
    }
    
    /**
     * @author Audrey
     * @return the accumulated error over time in the distance between where the robot is and where it should be in inches.
     */
    public double getAccumulatedLeftDistanceError() {
    	
    	accumulatedLeftDistanceError += getLeftDistanceError() * Utilities.getCycleTime();
    	
    	return accumulatedLeftDistanceError;
    }
    
    /**
     * @author Audrey
     * @return the accumulated error over time in the distance between where the robot is and where it should be in inches.
     */
    public double getAccumulatedRightDistanceError() {
    	
    	accumulatedRightDistanceError += getRightDistanceError() * Utilities.getCycleTime();
    	
    	return accumulatedRightDistanceError;
    }
    
    /**
     * @author Audrey
     * @return the error in the angle between what angle the robot is at and the angle it should be at in degrees.
     */
    public double getAngleError() {
    	
    	double error;
    	
		error = Utilities.angleDifference(driveTrain.getAngle(), (startingAngle + profile.idealAngle(timer.get())));
    	
    	return error;
    }
    
    /**
     * @author Audrey
     * @return the accumulated error over time in the angle between what angle the robot is at and the angle it should be at in degrees.
     */
    public double getAccumulatedAngleError() {
    	
    	accumulatedAngleError += getAngleError() * Utilities.getCycleTime();
    	
    	return accumulatedAngleError;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	driveTrain.tankDrive(profile.leftThrottle(timer.get()) + driveProportionality * getLeftDistanceError() + driveIntegral * getAccumulatedLeftDistanceError() + turnProportionality * getAngleError(),
				profile.rightThrottle(timer.get()) - turnProportionality * getAngleError());
    	
    	System.out.println(getAngleError());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if ((driveTrain.getLeftEncoder() >= (profile.getLeftDistance()*12 - distanceThreshold) &&
    			driveTrain.getLeftEncoder() <= (profile.getLeftDistance()*12 + distanceThreshold)) &&
        	(driveTrain.getRate() >= -velocityThreshold
    			&& driveTrain.getRate() <= velocityThreshold) &&
    		(driveTrain.getNavXYaw() >= -angleThreshold
    				&& driveTrain.getNavXYaw() <= angleThreshold) && 
    		(driveTrain.getYawRate() >= -angularVelocityThreshold
    				&& driveTrain.getYawRate() <= angularVelocityThreshold)){ //conditions may cancel
    		
    		System.out.println("FINISHIMO!!!!");
    		
    		return true;
    	}
    	else { //Timeout may cancel
    		
    		return isTimedOut();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
