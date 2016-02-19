package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Sheila
 * 
 * turns the scissor lift relay on, releasing the scissor lift
 */
public class StartScissorRelay extends CommandBase {

    public StartScissorRelay() {
    	requires(scissorLift);
    }
    
    protected void initialize() {
    	scissorLift.relayOn();
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
