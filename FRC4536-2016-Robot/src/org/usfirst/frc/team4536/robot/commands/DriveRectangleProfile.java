package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.RectangleProfile;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *@author Mairead
 */
public class DriveRectangleProfile extends CommandBase {
	
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
    
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	driveTrain.resetEncoders();
    }
    
    protected void execute() {
    	
    	time = timer.get();
    	
		driveTrain.arcadeDrive(rectangle.throttle(time)
				+ 0.75*(rectangle.idealDistance(time) - driveTrain.getEncoder()/12),
				(maxVelocity/24.6)*Utilities.angleDifference(driveTrain.getNavXYaw() , 0));
    	//Ask Caleb or Mairead on the implementation of feedforward+feedback
    	
		System.out.println(driveTrain.getEncoder()/12);
    	//Since getDistance is in feet, you have to divide by 12 to inches
    	
    }
    
    protected boolean isFinished() {
		if(Math.abs(driveTrain.getEncoder() - desiredDistance) < 0.04
				//in feet, true if the robot is within half of an inch away from the desired distance
			&& Math.abs(driveTrain.getRate()) < 0.5)
				//in inches, true in the robot is moving at a steep of less than half an inch
		{
			return true;
		}
		else
			return false;
    }
    
    protected void end() {
    	driveTrain.arcadeDrive(0, 0);
    }
    
    protected void interrupted() {
    }
}
