package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpyBotLowGoal extends CommandGroup {
    
    public  SpyBotLowGoal() {
    	
    	addParallel(new ReleaseIntake());
    	addSequential(new DriveTrapezoidProfile(Constants.SPY_BOT_LOW_GOAL_FIRST_LEG_DISTANCE));
    	addSequential(new TurnTrapezoidProfile(Constants.SPY_BOT_LOW_GOAL_TURN_ANGLE,
    						Constants.SPY_BOT_LOW_GOAL_MAX_ANGULAR_SPEED,
    						Constants.SPY_BOT_LOW_GOAL_MAX_ANGULAR_ACCELERATION));
    	addSequential(new DriveTrapezoidProfile(Constants.SPY_BOT_LOW_GOAL_SECOND_LEG_DISTANCE));
    	addSequential(new EjectBoulderAccelLimited());
    }
}