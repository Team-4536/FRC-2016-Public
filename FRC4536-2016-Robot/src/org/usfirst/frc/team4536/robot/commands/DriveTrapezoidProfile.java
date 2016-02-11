package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Mairead
 */
public class DriveTrapezoidProfile extends CommandBase {
	
	Timer timer = new Timer();
	double time;
	TrapezoidProfile trapezoid;
	public double maxVelocity;
	
	/**
	 * @author Mairead
	 * @param distance The desired distance the robot should travel
	 * @param desiredMaxVelocity The speed the robot should be traveling at
	 */

    public DriveTrapezoidProfile(double distance, double maxVelocity, double maxAcceleration) {

    	requires(driveTrain);
    	trapezoid = new TrapezoidProfile(distance, maxVelocity, maxAcceleration);
    	this.maxVelocity = maxVelocity;
    }
    
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
    	
    	time = timer.get();
    	
    	driveTrain.arcadeDrive(trapezoid.throttle(time), 0);
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