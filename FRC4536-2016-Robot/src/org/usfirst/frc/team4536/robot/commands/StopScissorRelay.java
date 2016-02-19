package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Sheila
 * 
 * set the scissor lift relay off, so it stops the scissor lift from moving through it
 */
public class StopScissorRelay extends CommandBase {

    public StopScissorRelay() {
    	requires(scissorLift);
    }
    
    protected void initialize() {
    	scissorLift.relayOff();
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
