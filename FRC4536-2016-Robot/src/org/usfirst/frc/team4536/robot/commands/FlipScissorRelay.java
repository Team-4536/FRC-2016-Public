package org.usfirst.frc.team4536.robot.commands;

/**
 *
 */
public class FlipScissorRelay extends CommandBase {

    public FlipScissorRelay() {
    	requires(scissorLift);
    }
    
    protected void initialize() {
    	scissorLift.relayFlip();
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
