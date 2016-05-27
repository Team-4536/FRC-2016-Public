package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 * @author Sheila
 */
public class DriveAccelLimited extends CommandBase {

    public DriveAccelLimited() {
    	requires(driveTrain);
    }
    
    protected void initialize() {
    	
    }
    
    protected void execute() {
    	
    	driveTrain.arcadeDriveAccelLimit(Utilities.speedCurve(
    			Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE), Constants.SPEED_CURVE_STRAIGHT), 
    			Utilities.speedCurve(
    			Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE),Constants.SPEED_CURVE_TURN));
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
