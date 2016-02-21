package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Liam
 */
public class PlopBoulder extends CommandBase {

	private boolean finished;
	private double range;
	
    public PlopBoulder() {
    	
        requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	setTimeout(Constants.PLOP_BOULDER_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	range = intake.getdistance();
    	
    	if (range < Constants.PLOP_BOULDER_CLOSE_DIST) {
    		
    		intake.setThrottle(Constants.PLOP_BOULDER_FAST_SPEED);
    		finished = false;
    	}
    	else if (range >= Constants.PLOP_BOULDER_CLOSE_DIST && range < Constants.PLOP_BOULDER_FAR_DIST) {
    		
    		intake.setThrottle(Constants.PLOP_BOULDER_SLOW_SPEED);
    		finished = false;
    	}
    	else {
    		
    		intake.setThrottle(0.0);
    		finished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (finished) {
    		
    		return true;
    	}
    	
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	intake.resetAccelValues();
    	intake.setThrottle(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}
