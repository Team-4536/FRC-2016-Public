package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Liam
 */
public class DriveTrapezoidProfile extends CommandBase {
	
	Timer timer = new Timer();
	TrapezoidProfile trapezoid;
	double startingAngle;
	double proportionalityConstant = Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY;
	
	/**
	 * @author Liam
	 * @param distance The desired distance the robot should travel. May be negative or positive to indicate direction.
	 * @param maxSpeed The maximum possible speed the robot could be traveling at. Always positive.
	 * @param maxAcceleration The maximum possible acceleration the speed can change by. Always positive.
	 */
    public DriveTrapezoidProfile(double distance, double maxSpeed, double maxAcceleration) {

    	requires(driveTrain);
    	trapezoid = new TrapezoidProfile(distance, maxSpeed, maxAcceleration);
    }
    
    public DriveTrapezoidProfile(double distance, double maxSpeed, double maxAcceleration, double gyroProportionality) {
    	requires(driveTrain);
    	trapezoid = new TrapezoidProfile(distance, maxSpeed, maxAcceleration);
    	proportionalityConstant = gyroProportionality;
    }
    
    /**
     * @author Liam
     * @return time time in seconds since the command was started
     */
    public double getTime() {
    	
    	return timer.get();
    }
    
    /**
     * @author Audrey
     * @return time needed from the trapezoid profile method
     */
    public double getNeededTime(){
    	
    	return trapezoid.getTimeNeeded();
    }

 // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	driveTrain.resetRightEncoder();
    	startingAngle = driveTrain.getNavXYaw();
    	setTimeout(trapezoid.getTimeNeeded() + Constants.TRAPEZOID_PROFILE_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.arcadeDrive(trapezoid.throttle(timer.get()) + (Constants.TRAPEZOID_FORWARD_PROPORTIONALITY * (trapezoid.idealDistance(timer.get())*12 - driveTrain.getRightEncoder())),
    							(proportionalityConstant * Utilities.angleDifference(startingAngle,driveTrain.getNavXYaw())));
    	//Ask Caleb or Mairead on the implementation of feedforward+feedback
    	
    	System.out.println(driveTrain.getRightEncoder()/12);
    	//Since getDistance is in feet, you have to divide by 12 to inches
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if ((driveTrain.getRightEncoder() >= (trapezoid.getDistance()*12 - Constants.TRAPEZOID_DISTANCE_THRESHOLD) &&
    			driveTrain.getRightEncoder() <= (trapezoid.getDistance()*12 + Constants.TRAPEZOID_DISTANCE_THRESHOLD)) &&
        	(driveTrain.getRightRate() >= -Constants.TRAPEZOID_SPEED_THRESHOLD
    			&& driveTrain.getRightRate() <= Constants.TRAPEZOID_SPEED_THRESHOLD) &&
    		(driveTrain.getNavXYaw() >= -Constants.TRAPEZOID_ANGLE_THRESHOLD
    				&& driveTrain.getNavXYaw() <= Constants.TRAPEZOID_ANGLE_THRESHOLD) && 
    		(driveTrain.getYawRate() >= -Constants.TRAPEZOID_ANGULAR_SPEED_THRESHOLD
    				&& driveTrain.getYawRate() <= Constants.TRAPEZOID_ANGULAR_SPEED_THRESHOLD)){ //conditions may cancel
    		
    		return true;
    	}
    	else { //Timeout may cancel
    		
    		return isTimedOut();
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}
