package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 * @author Noah
 */
public class DriveTrainCommand extends CommandBase {

    public DriveTrainCommand() {
    	requires(driveTrain);
    }
    
    protected void initialize() {
    	
    }
    
    protected void execute() {
    	
    	double mainStickY = -OI.mainStick.getY();
    	double mainStickX = OI.mainStick.getX();
    	
    	mainStickY = Utilities.deadZone(mainStickY, Constants.DEAD_ZONE);
    	mainStickX = Utilities.deadZone(mainStickX, Constants.DEAD_ZONE);
    	
    	mainStickY = Utilities.limit(mainStickY, Constants.SPEED_LIMIT);
    	mainStickX = Utilities.limit(mainStickX, Constants.SPEED_LIMIT);
    	
    	mainStickY = Utilities.speedCurve(mainStickY, Constants.SPEED_CURVE_STRAIGHT);
    	mainStickX = Utilities.speedCurve(mainStickX, Constants.SPEED_CURVE_TURN);
    	
    	driveTrain.arcadeDriveAccelLimit(mainStickY, mainStickX);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
