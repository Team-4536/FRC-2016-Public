package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.Filter;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *
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
    	System.out.println("Starting Time: " + startingTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	System.out.println("Time: "  + (Utilities.getTime() - startingTime));
    	
    	intake.setThrottle(1.0);
    	
    	if (Utilities.getTime() - startingTime > 1)
    	filter.update(Utilities.getCurrent(RobotMap.PDP_INTAKE));
    	System.out.println(filter.getMean(numDataPoints));
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
