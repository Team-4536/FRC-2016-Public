package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Noah
 *Score in the low goal after crossing the low goal
 */
public class LowBarLowGoal extends CommandGroup {
    
    public  LowBarLowGoal() {
    	
    	addSequential(new CrossLowBar());
    	addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.LOW_BAR_LOW_GOAL_FIRST_LEG_ANGLE), Constants.LOW_BAR_LOW_GOAL_FIRST_LEG_ANGLE));
    	addSequential(new DriveProfile(new TrapezoidProfile(Constants.LOW_BAR_LOW_GOAL_FIRST_LEG_DISTANCE, Constants.TRAPEZOID_DEFAULT_SPEED, Constants.TRAPEZOID_DEFAULT_ACCELERATION), Constants.LOW_BAR_LOW_GOAL_FIRST_LEG_ANGLE, Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY)); // 7
    	addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.LOW_BAR_LOW_GOAL_SECOND_LEG_ANGLE), Constants.LOW_BAR_LOW_GOAL_SECOND_LEG_ANGLE)); // 50
    	addSequential(new DriveProfile(new TrapezoidProfile(Constants.LOW_BAR_lOW_GOAL_SECOND_LEG_DISTANCE, Constants.TRAPEZOID_DEFAULT_SPEED, Constants.TRAPEZOID_DEFAULT_ACCELERATION), Constants.LOW_BAR_LOW_GOAL_FIRST_LEG_ANGLE, Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY)); // 5
    	addSequential(new EjectBoulderAccelLimited());
    }
}
