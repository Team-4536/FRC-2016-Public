package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Sheila
 * 
 * checks whether the scissor lift's relay is off, and flips it once
 * (if it is off turn it on, if it is on turn it off)
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
