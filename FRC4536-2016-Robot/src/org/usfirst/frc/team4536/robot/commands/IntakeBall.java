package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Liam
 */
public class IntakeBall extends CommandBase {
	
	private double speed = Constants.INTAKE_SPEED;
	
    public IntakeBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(intake);
    	requires(maxUltra);
    }
    
    public IntakeBall(double speed) {
    	
    	this();
    	
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	setTimeout(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    if (maxUltra.getRange() < .25) {
    		intake.setThrottle(0);
    	}
    	else {
    		intake.setThrottle(speed);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	intake.setThrottle(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}
