package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Liam
 *Releases the intake so it is deployed from the robot
 */
public class ReleaseIntake extends CommandBase {

    public ReleaseIntake() {

    	requires(intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	intake.resetAccelValues();
    	
    	setTimeout(Constants.INTAKE_RELEASE_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	intake.setThrottleAccelLimited(Constants.INTAKE_RELEASE_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	intake.resetAccelValues();
    	intake.setThrottleAccelLimited(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}
