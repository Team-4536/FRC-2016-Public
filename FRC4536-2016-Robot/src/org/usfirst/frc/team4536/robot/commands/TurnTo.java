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
	
	Timer timer;
	RectangleProfileForTurning rectangle;


    public TurnTo(double desiredAngle, double velocity) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    	
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
    	
    	driveTrain.arcadeDrive(0, rectangle.throttle(time));
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
