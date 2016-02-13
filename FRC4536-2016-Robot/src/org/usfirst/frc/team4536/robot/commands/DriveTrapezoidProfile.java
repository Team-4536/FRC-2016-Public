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
	public double maxVelocity;
	
	/**
	 * @author Liam
	 * @param distance The desired distance the robot should travel
	 * @param desiredMaxVelocity The speed the robot should be traveling at
	 */

    public DriveTrapezoidProfile(double distance, double maxVelocity, double maxAcceleration) {

    	requires(driveTrain);
    	trapezoid = new TrapezoidProfile(distance, maxVelocity, maxAcceleration);
    	this.maxVelocity = maxVelocity;
    }
    
    /**
     * @author Liam
     * @return time
     */
    public double getTime() {
    	
    	return timer.get();
    }

 // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	driveTrain.resetRightEncoder();
    	driveTrain.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.arcadeDrive(trapezoid.throttle(timer.get()) + (Constants.TRAPEZOID_FORWARD_PROPORTIONALITY * (trapezoid.idealDistance(timer.get())*12 - driveTrain.getRightEncoder())),
    							(Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY * driveTrain.getNavXYaw()));
    	//Ask Caleb or Mairead on the implementation of feedforward+feedback
    	
    	System.out.println(driveTrain.getRightEncoder()/12);
    	//Since getDistance is in feet, you have to divide by 12 to inches
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {

    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}