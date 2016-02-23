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
    	addSequential(new TurnTrapezoidProfile(10));
    	addSequential(new DriveTrapezoidProfile(Constants.variable1)); // 7
    	addSequential(new TurnTrapezoidProfile(Constants.variable3)); // 50
    	addSequential(new DriveTrapezoidProfile(Constants.variable2)); // 5
    	addSequential(new EjectBoulderAccelLimited());
    }
}
