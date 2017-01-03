package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *@author Noah
 */
public class DriveIntakeAccelLimited extends CommandBase {
	
    public DriveIntakeAccelLimited() {
    	requires(intake);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	double intakeY = -OI.secondaryStick.getY();
    	
    	intakeY = Utilities.deadZone(intakeY, Constants.DEAD_ZONE);
    	intakeY = Utilities.speedCurve(intakeY, Constants.INTAKE_SPEED_CURVE);
    	
    	intake.setThrottleAccelLimited(intakeY);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	
    	intake.setThrottle(0.0);
    }
    
    protected void interrupted() {
    }
}
