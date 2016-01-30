package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.Constants;

/**
 *@author Liam
 *This commmand reaches the outerworks, scoring 2 points in auto.
 */
public class ReachOuterWorks extends Commandbase {
	
	//TODO add timeout for the comand

    public ReachOuterWorks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	setTimeout(Constants.REACH_DEFENSE_TIME_OUT);
    	
    	System.out.println("Initiailized");
    	
    	driveTrain.arcadeDrive(0.0, 0.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	System.out.println("Driving");
    	driveTrain.arcadeDrive(0.5, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	driveTrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}
