package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

/**
 *@author Liam
 */
public class EjectBoulderAccelLimited extends CommandBase {

    public EjectBoulderAccelLimited() {
    	requires(intake);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	
    	intake.setThrottleAccelLimited(Constants.EJECT_SPEED);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	
    	intake.setThrottle(0.0);
    }
    
    protected void interrupted() {
    	
    	
    }
}
