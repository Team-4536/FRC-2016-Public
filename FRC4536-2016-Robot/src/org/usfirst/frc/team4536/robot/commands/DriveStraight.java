package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *@author Noah
 */
public class DriveStraight extends CommandBase {
	
	private double startingAngle;
	private boolean original = false;

    public DriveStraight() {
        
    	requires(driveTrain);
    	original = true;
    	
    }
    
    public DriveStraight(double angle) {
    	
    	requires(driveTrain);
    	startingAngle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if (original){
    		
    		startingAngle = driveTrain.getAngle();
    	}

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.arcadeDriveAccelLimit(Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE), Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY*(Utilities.angleDifference(startingAngle, driveTrain.getAngle())));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	driveTrain.resetAccelValues();
    	driveTrain.arcadeDrive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}
