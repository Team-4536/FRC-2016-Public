package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Sheila
 * 
 * checks whether the intake's relay is off, and flips it once
 * (if it is off turn it on, if it is on turn it off)
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
