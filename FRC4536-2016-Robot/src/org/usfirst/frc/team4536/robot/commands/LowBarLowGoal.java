package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 *Score in the low goal after crossing the low goal
 */
public class LowBarLowGoal extends CommandGroup {
    
    public  LowBarLowGoal() {
    	
    	addSequential(new CrossLowBar());
    	addSequential(new TurnTrapezoidProfile(Constants.LOW_BAR_LOW_GOAL_FIRST_LEG_ANGLE));
    	addSequential(new DriveTrapezoidProfile(Constants.LOW_BAR_LOW_GOAL_FIRST_LEG_DISTANCE)); // 7
    	addSequential(new TurnTrapezoidProfile(Constants.LOW_BAR_LOW_GOAL_SECOND_LEG_ANGLE)); // 50
    	addSequential(new DriveTrapezoidProfile(Constants.LOW_BAR_lOW_GOAL_SECOND_LEG_DISTANCE)); // 5
    	addSequential(new EjectBoulderAccelLimited());
    }
}
