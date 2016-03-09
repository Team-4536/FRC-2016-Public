package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Liam
 */
public class DriveStraight extends CommandBase {
	
	private double startingAngle;
	private double offset;

    public DriveStraight() {
        
    	requires(driveTrain);
    }
    
    public DriveStraight(double offset) {
    	
    	this.offset = offset;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	startingAngle = driveTrain.getNavXYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.arcadeDriveAccelLimit(Utilities.deadZone(OI.mainStick.getY(), Constants.DEAD_ZONE), Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY*(driveTrain.getNavXYaw()-startingAngle));
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
