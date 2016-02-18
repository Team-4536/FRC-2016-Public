package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Sheila
 * 
 * turns the scissor lift relay on, releasing the scissor lift
 */
public class StartScissorRelay extends CommandBase {

    public StartScissorRelay() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(scissorLift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	scissorLift.relayOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
