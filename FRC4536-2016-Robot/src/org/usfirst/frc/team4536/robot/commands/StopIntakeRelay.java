package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Sheila
 * 
 * sets the intake relay off, so it stops the intake from moving through it
 */
public class StopIntakeRelay extends CommandBase {

    public StopIntakeRelay() {
    	requires(intake);
    }
    
    protected void initialize() {
    	intake.relayOff();
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
