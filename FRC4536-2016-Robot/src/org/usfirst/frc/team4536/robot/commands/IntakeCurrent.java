package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.Filter;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *@author Liam
 */
public class IntakeCurrent extends CommandBase {
	
	private final Filter filter;
	private final int numDataPoints = 20;
	private double startingTime;

    public IntakeCurrent() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(intake);
    	filter = new Filter();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	startingTime = Utilities.getTime();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	intake.setThrottle(1.0);
    	
    	if (Utilities.getTime() - startingTime > Constants.AUTO_INTAKE_DELAY) {
    		
    		filter.update(Utilities.getCurrent(RobotMap.PDP_INTAKE));
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (filter.getMean(numDataPoints) > Constants.AUTO_INTAKE_CURRENT) {
    		
    		return true;
    	}
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	filter.clear();
    	intake.setThrottle(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}
