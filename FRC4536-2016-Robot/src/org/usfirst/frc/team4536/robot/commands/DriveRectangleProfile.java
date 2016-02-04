package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.RectangleProfile;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class DriveRectangleProfile extends Commandbase {
	
	Timer timer = new Timer();
	double time;
	double desiredDistance;
	double maxVelocity;
	RectangleProfile rectangle;
	
	/**
	 * @author Mairead
	 * @param distance The desired distance the robot should travel
	 * @param desiredMaxVelocity The speed the robot should be traveling at
	 */

    public DriveRectangleProfile(double distance, double maxVelocity) {

    	requires(driveTrain);
    	rectangle = new RectangleProfile(distance, maxVelocity);
    	this.desiredDistance = distance;
    	this.maxVelocity = maxVelocity;
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
    	
    	driveTrain.arcadeDrive(rectangle.throttle(time)
    			+ 0.75*(rectangle.idealDistance(time) - driveTrain.getRightEncoder()/12),
    			-(maxVelocity/24.6)*driveTrain.gyroAngle());
//    +	0.75*(rectangle.idealDistance(time) - driveTrain.getRightEncoder()/12)
    	//Ask Caleb or Mairead on the implementation of feedforward+feedback
    	
    	System.out.println(driveTrain.getRightEncoder()/12);
    	//Since getDistance is in feet, you have to divide by 12 to inches
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(driveTrain.getRightEncoder() - desiredDistance) < 0.04
    			//in feet, true if the robot is within half of an inch away from the desired distance
    		&& Math.abs(driveTrain.getRightRate()) < 0.5)
    			//in inches, true in the robot is moving at a steep of less than half an inch
    	{
    		return true;
    	}
    	else
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
