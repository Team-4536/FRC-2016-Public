package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

/**
 * @author Liam
 * Intakes the ball without an accel limit
 */
public class IntakeBoulder extends CommandBase {
	
	private double speed = Constants.INTAKE_SPEED;
	
    public IntakeBoulder() {
    	requires(intake);
    }
    
    public IntakeBoulder(double speed) {
    	
    	this();
    	
    	this.speed = speed;
    }
    
    protected void initialize() {
    	
    	setTimeout(1.0);
    }
    
    protected void execute() {
    	if (intake.getdistance() < .25) {
    		intake.setThrottle(0);
    	}
    	else {
    		intake.setThrottle(speed);
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
