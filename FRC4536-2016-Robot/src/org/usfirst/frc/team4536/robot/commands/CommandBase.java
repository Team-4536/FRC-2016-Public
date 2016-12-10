package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.Intake;
import org.usfirst.frc.team4536.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Noah
 * This is the class that every command extends
 */
public class CommandBase extends Command {
	
	public static DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_MOTOR_BACK, 			  RobotMap.LEFT_MOTOR_FRONT,
															RobotMap.RIGHT_MOTOR_BACK, 		  RobotMap.RIGHT_MOTOR_FRONT,
															RobotMap.LEFT_ENCODER_CHANNEL_A,  RobotMap.LEFT_ENCODER_CHANNEL_B,
															RobotMap.RIGHT_ENCODER_CHANNEL_A, RobotMap.RIGHT_ENCODER_CHANNEL_B,
															RobotMap.FRONT_ULTRA_CHANNEL, 	  RobotMap.BACK_ULTRA_CHANNEL,
															RobotMap.LEFT_IR_CHANNEL);
	public static Intake intake = new Intake(RobotMap.INTAKE_MOTOR_CHANNEL, RobotMap.INTAKE_RELAY, RobotMap.INTAKE_IR_CHANNEL);
	public static ScissorLift scissorLift = new ScissorLift(RobotMap.SCISSOR_MOTOR);
	
    public CommandBase() {
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}