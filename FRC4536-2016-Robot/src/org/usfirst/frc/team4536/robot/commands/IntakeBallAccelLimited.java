package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

/**
 * @author Noah
 * Intakes the ball with an accel limit
 */
public class IntakeBallAccelLimited extends CommandBase {
	
    public IntakeBallAccelLimited() {
    	requires(intake);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	if (intake.getdistance() < .25) {
    		intake.setThrottle(0);
    	}
    	else {
    		intake.setThrottleAccelLimited(Constants.INTAKE_SPEED);
    	}
    }
    
    protected boolean isFinished() {
    	return isTimedOut();
    }
    
    protected void end() {
    	
    	intake.setThrottle(0.0);
    }
    
    protected void interrupted() {
    	end();
    }
}
