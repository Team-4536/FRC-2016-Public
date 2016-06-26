package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.Filter;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *
 */
public class IntakeCurrent extends Command {
	
	Filter filter;

    public IntakeCurrent() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	filter = new Filter();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	filter.update(Utilities.getCurrent(RobotMap.PDP_INTAKE));
    	
    	System.out.print(filter.get(filter.getSize()-1) + ",");
    	//System.out.print(filter.getMean(3)); //PROBLEM Unhandled exception out of bounds
    	System.out.println();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
