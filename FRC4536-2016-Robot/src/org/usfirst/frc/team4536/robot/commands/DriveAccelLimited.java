package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 * @author Sheila
 */
public class DriveAccelLimited extends CommandBase {

    public DriveAccelLimited() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveTrain.arcadeDriveAccelLimit(Utilities.speedCurve(
    			Utilities.deadZone(-OI.mainStick.getY(), Constants.DEAD_ZONE), Constants.SPEED_CURVE_STRAIGHT), 
    			Utilities.speedCurve(
    			Utilities.deadZone(OI.mainStick.getX(), Constants.DEAD_ZONE),Constants.SPEED_CURVE_TURN));
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
