package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.Profile;
import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.TurnProfile;
import org.usfirst.frc.team4536.robot.DriveStraightProfile;
import org.usfirst.frc.team4536.robot.Integral;
import java.util.ArrayList;

/**
 *@author Liam
 */
public class DriveProfile extends CommandBase {

	private final Profile profile;
	private ArrayList<Profile> profiles;
	private final Timer timer = new Timer();
	private double desiredAngle = 0.0;
	private double startingAngle = 0.0;
	private boolean fieldAngle = true;
	private double turnProportionality = Constants.DEFAULT_CROSSING_GYRO_PROPORTIONALITY;
	private double accumulatedDistanceError = 0.0;
	private double accumulatedAngleError = 0.0;
    
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
     * @author Liam
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
    	
    	accumulatedDistanceError = 0.0;
    	accumulatedAngleError = 0.0;
    	
    	driveTrain.resetEncoders();
    	
    	if (fieldAngle) {
    		
    		desiredAngle = driveTrain.getAngle();
    	}
    	
    	if (profile instanceof TurnProfile) {
    		
        	startingAngle = driveTrain.getAngle();
        	double angleDiff = Utilities.angleDifference(startingAngle, desiredAngle);
        	((TurnProfile) profile).setTurnProfile(angleDiff);
    	}

    	setTimeout(profile.getTimeNeeded() + profile.getTimeoutOffset());
    }
    
    /**
     * @author Liam
     * @return the error in the distance between where the robot is and where it should be in inches.
     * @throws RuntimeException when you call this method on a turn profile. Turn profiles don't track distance error.
     */
    public double getDistanceError() throws RuntimeException {
    	
    	if (profile instanceof TurnProfile) {
    		
    		throw new RuntimeException("You should not be calling distance error on a turning profile.");
    	}
    	
    	double error = profile.idealDistance(timer.get())*12 - driveTrain.getRightEncoder();
    	
    	return error;
    }
    
    /**
     * @author Liam
     * @return the accumulated error over time in the distance between where the robot is and where it should be in inches.
     */
    public double getAccumulatedDistanceError() throws RuntimeException {
    	
    	accumulatedDistanceError += getDistanceError() * Utilities.getCycleTime();
    	
    	return accumulatedDistanceError;
    }
    
    /**
     * @author Liam
     * @return the error in the angle between what angle the robot is at and the angle it should be at in degrees.
     */
    public double getAngleError() {
    	
    	double error;
    	
    	if (profile instanceof TurnProfile) {
    		
    		error = Utilities.angleDifference(driveTrain.getAngle(), (startingAngle + profile.idealDistance(timer.get())));
    		
    		return error;
    	}
    	
    	error = Utilities.angleDifference(desiredAngle, driveTrain.getAngle());
    	
    	return error;
    }
    
    /**
     * @author Liam
     * @return the accumulated error over time in the angle between what angle the robot is at and the angle it should be at in degrees.
     */
    public double getAccumulatedAngleError() {
    	
    	accumulatedAngleError += getAngleError() * Utilities.getCycleTime();
    	
    	return accumulatedAngleError;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() throws RuntimeException {
    	
    	if (profile instanceof TurnProfile) {
    		
    		if (profile instanceof Integral) {
    			
	        	driveTrain.arcadeDriveAccelLimit(0.0, profile.throttle(timer.get())
	        			+ profile.getTurnProportionality()*getAngleError() + profile.getTurnIntegral() * getAccumulatedAngleError());
    		}
    		else {
    			
    			driveTrain.arcadeDrive(0.0, profile.throttle(timer.get())
    					+ profile.getTurnProportionality()*getAngleError());
    		}
    	}
    	else {
    		
    		if (profile instanceof Integral) {
    			
	        	driveTrain.arcadeDrive(profile.throttle(timer.get()) + ((DriveStraightProfile) profile).getDriveProportionality() * getDistanceError() + ((DriveStraightProfile) profile).getDriveIntegral() * getAccumulatedDistanceError(),
						(profile.getTurnProportionality() * getAngleError() - profile.getTurnIntegral() * getAccumulatedAngleError()));
    		}
    		else {
    			
    			driveTrain.arcadeDrive(profile.throttle(timer.get()) + ((DriveStraightProfile) profile).getDriveProportionality() * getDistanceError(),
    					(profile.getTurnProportionality() * getAngleError()));
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (profile instanceof TurnProfile) {
    		
        	if ((Math.abs(driveTrain.getAngle() - desiredAngle) <= profile.getAngleThreshold()  &&
            		(Math.abs(driveTrain.getYawRate()) <= profile.getAngularVelocityThreshold()))){ // Conditions may end
        		
        		return true;
        	}
        	else { // time out may end
        		
        		return isTimedOut();
        	}
    	}
    	else {
    		
        	if ((driveTrain.getEncoder() >= ((DriveStraightProfile) profile).getDistance()*12 - ((DriveStraightProfile) profile).getDistanceThreshold() &&
        			driveTrain.getEncoder() <= ((DriveStraightProfile) profile).getDistance()*12 + ((DriveStraightProfile) profile).getDistanceThreshold()) &&
            	(driveTrain.getRate() >= -((DriveStraightProfile) profile).getVelocityThreshold()
        			&& driveTrain.getRate() <= ((DriveStraightProfile) profile).getVelocityThreshold()) &&
        		(driveTrain.getNavXYaw() >= -profile.getAngleThreshold()
        				&& driveTrain.getNavXYaw() <= profile.getAngleThreshold()) && 
        		(driveTrain.getYawRate() >= -profile.getAngularVelocityThreshold()
        				&& driveTrain.getYawRate() <= profile.getAngularVelocityThreshold())){ //conditions may cancel
        		
        		return true;
        	}
        	else { //Timeout may cancel
        		
        		return isTimedOut();
        	}
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
