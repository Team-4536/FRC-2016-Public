package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	 * @param the distance desired to be travelled
	 * Sets the Max Speed and Acceleration to the defaults defined in constants
	 */
	public DriveTrapezoidProfile(double distance) {
		
		this(distance, Constants.TRAPEZOID_DEFAULT_SPEED, Constants.TRAPEZOID_DEFAULT_ACCELERATION);
	}
	
	/**
	 * @author Liam
	 * @param distance The desired distance the robot should travel in feet. May be negative or positive to indicate direction.
	 * @param maxSpeed The maximum possible speed the robot could be traveling at in feet per second. Always positive.
	 * @param maxAcceleration The maximum possible acceleration the speed can change by in feet per second squared. Always positive.
	 */
    public DriveTrapezoidProfile(double distance, double maxSpeed, double maxAcceleration) {

    	requires(driveTrain);
    	trapezoid = new TrapezoidProfile(distance, maxSpeed, maxAcceleration);
    }
    
	/**
	 * @author Liam
	 * @param distance The desired distance the robot should travel in feet. May be negative or positive to indicate direction.
	 * @param maxSpeed The maximum possible speed the robot could be traveling at in feet per second. Always positive.
	 * @param maxAcceleration The maximum possible acceleration the speed can change by in feet per second squared. Always positive.
	 * @param custom gyro proportionality constant to override the default. Useful for command groups that may require more correction due to terrain.
	 */
    public DriveTrapezoidProfile(double distance, double maxSpeed, double maxAcceleration, double gyroProportionality) {
    	
    	this(distance, maxSpeed, maxAcceleration);
    	proportionalityConstant = gyroProportionality;
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
     * @return time needed from the trapezoid profile method
     */
    public double getNeededTime(){
    	
    	return trapezoid.getTimeNeeded();
    }
    
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	
    	driveTrain.resetEncoders();
    	startingAngle = driveTrain.getAngle();
    	setTimeout(trapezoid.getTimeNeeded() + Constants.TRAPEZOID_PROFILE_TIMEOUT_OFFSET);
    }
    
    protected void execute() {
    	
    	driveTrain.arcadeDrive(trapezoid.throttle(timer.get()) + (Constants.TRAPEZOID_FORWARD_PROPORTIONALITY * (trapezoid.idealDistance(timer.get())*12 - driveTrain.getLeftEncoder())),
    							(proportionalityConstant * Utilities.angleDifference(startingAngle,driveTrain.getAngle())));
    	//Ask Caleb or Mairead on the implementation of feedforward+feedback
    	
		System.out.println(driveTrain.getEncoder()/12);
    	//Since getDistance is in feet, you have to divide by 12 to inches
    	
    }
    
    protected boolean isFinished() {
    	
		if ((driveTrain.getEncoder() >= (trapezoid.getDistance()*12 - Constants.TRAPEZOID_DISTANCE_THRESHOLD) &&
				driveTrain.getEncoder() <= (trapezoid.getDistance()*12 + Constants.TRAPEZOID_DISTANCE_THRESHOLD)) &&
			(driveTrain.getRate() >= -Constants.TRAPEZOID_SPEED_THRESHOLD
				&& driveTrain.getRate() <= Constants.TRAPEZOID_SPEED_THRESHOLD) &&
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
    
    protected void end() {
    	driveTrain.arcadeDrive(0, 0);
    }
    
    protected void interrupted() {
    	
    	end();
    }
}
