package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *@author Audrey
 *This command is for driving without an acceleration limit, but with a dead zone and speed curve
 */
public class DriveIntakeArm extends CommandBase {

    public DriveIntakeArm() {
    	requires(intake);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	double intakeY = -OI.secondaryStick.getY();
    	
    	intakeY = Utilities.deadZone(intakeY, Constants.DEAD_ZONE);
    	intakeY = Utilities.limit(intakeY);
    	intakeY = Utilities.speedCurve(intakeY, Constants.INTAKE_SPEED_CURVE);
    	
    	intake.setThrottleAccelLimited(intakeY);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
