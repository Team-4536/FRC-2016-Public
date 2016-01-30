package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.*;
import org.usfirst.frc.team4536.robot.Constants;

/**
 *
 */
public abstract class CommandBase extends Command {
	
	public static DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_MOTOR, RobotMap.RIGHT_MOTOR, Constants.LEFT_ENCODER_CHANNEL_A, Constants.LEFT_ENCODER_CHANNEL_B, Constants.RIGHT_ENCODER_CHANNEL_A, Constants.RIGHT_ENCODER_CHANNEL_B);
	public static CompressorSubsystem compressorSubsystem = new CompressorSubsystem();
	public static Piston piston = new Piston(RobotMap.leftSolenoid, RobotMap.rightSolenoid);
	
    public CommandBase() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
