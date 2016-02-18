package org.usfirst.frc.team4536.robot.commands;

/**
 *
 */
public class FlipIntakeRelay extends CommandBase {

    public FlipIntakeRelay() {
    	requires(intake);
    }
    
    protected void initialize() {
    	intake.relayFlip();
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
