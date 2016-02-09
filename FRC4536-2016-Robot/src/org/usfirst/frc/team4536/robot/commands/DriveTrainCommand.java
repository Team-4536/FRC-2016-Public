package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
//TODO Print Yaw, Pitch, and Roll to smartdashboard

public class DriveTrainCommand extends CommandBase {

    public DriveTrainCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double mainStickY = -OI.mainStick.getY();
    	double mainStickX = OI.mainStick.getX();
    	
    	mainStickY = Utilities.deadZone(mainStickY, Constants.DEAD_ZONE);
    	mainStickX = Utilities.deadZone(mainStickX, Constants.DEAD_ZONE);
    	
    	mainStickY = Utilities.limit(mainStickY, Constants.SPEED_LIMIT);
    	mainStickX = Utilities.limit(mainStickX, Constants.SPEED_LIMIT);
    	
    	mainStickY = Utilities.speedCurve(mainStickY, Constants.SPEED_CURVE_STRAIGHT);
    	mainStickX = Utilities.speedCurve(mainStickX, Constants.SPEED_CURVE_TURN);
    	
    	driveTrain.arcadeDrive(mainStickY, mainStickX);
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
