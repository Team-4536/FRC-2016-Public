package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpyBotLowGoal extends CommandGroup {
    
    public  SpyBotLowGoal() {
    	
    	addParallel(new ReleaseIntake());
    	addSequential(new DriveProfile(new TrapezoidProfile(Constants.SPY_BOT_LOW_GOAL_FIRST_LEG_DISTANCE), Constants.SPY_BOT_ANGLE));
    	addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.SPY_BOT_LOW_GOAL_TURN_ANGLE,
    						Constants.SPY_BOT_LOW_GOAL_MAX_ANGULAR_SPEED,
    						Constants.SPY_BOT_LOW_GOAL_MAX_ANGULAR_ACCELERATION), Constants.SPY_BOT_LOW_GOAL_TURN_ANGLE));
    	addSequential(new DriveProfile(new TrapezoidProfile(Constants.SPY_BOT_LOW_GOAL_SECOND_LEG_DISTANCE), Constants.SPY_BOT_LOW_GOAL_TURN_ANGLE));
    	addSequential(new EjectBoulderAccelLimited());
    }
}