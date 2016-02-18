package org.usfirst.frc.team4536.robot.commands;

/**
 *
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
