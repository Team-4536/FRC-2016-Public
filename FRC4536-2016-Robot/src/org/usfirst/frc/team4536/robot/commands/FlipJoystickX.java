package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

/**
 *
 */
public class FlipJoystickX extends CommandBase {

    public FlipJoystickX() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveTrain.flipDirection();
    	setTimeout(Constants.FLIP_DIRECTIONS_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
