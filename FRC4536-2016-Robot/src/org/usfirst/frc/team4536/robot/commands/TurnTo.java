package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.RectangleProfileForTurning;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class TurnTo extends CommandBase {
	
	double desiredAngle;
	double currentAngle;
	double difference;
	double time;
	double throttle;
	
	Timer timer = new Timer();
	RectangleProfileForTurning rectangle;


    public TurnTo(double desiredAngle, double velocity) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	
    	this.desiredAngle = desiredAngle;
    	currentAngle = driveTrain.getGyroAngle();
    	difference = Utilities.angleDifference(currentAngle, desiredAngle);
    	rectangle = new RectangleProfileForTurning(difference, velocity);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	time = timer.get();
    	
    	throttle = rectangle.throttle(time) - 0.009*(Utilities.angleDifference(rectangle.idealAngle(time), driveTrain.getGyroAngle()));
    	
    	driveTrain.arcadeDrive(0, throttle);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(((driveTrain.getGyroAngle() - desiredAngle) < 1) 
    		&& driveTrain.gyroRate() < 1){
    		return true;
    	}
    	
    	else  
    		return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
