package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Sheila
 * 
 * turns the intake relay on, releasing the intake
 */
public class StartIntakeRelay extends CommandBase {

    public StartIntakeRelay() {
    	requires(intake);
    }
    
    protected void initialize() {
    	intake.relayOn();
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
