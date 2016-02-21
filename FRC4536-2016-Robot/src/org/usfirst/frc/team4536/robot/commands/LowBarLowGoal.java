package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 *Score in the low goal after crossing the low goal
 */
public class LowBarLowGoal extends CommandGroup {
    
    public  LowBarLowGoal() {
    	
    	addSequential(new CrossLowBar());
    	addSequential(new TurnTrapezoidProfile(10));
    	addSequential(new DriveTrapezoidProfile(7));
    	addSequential(new TurnTrapezoidProfile(50));
    	addSequential(new DriveTrapezoidProfile(5));
    	addSequential(new EjectBoulderAccelLimited());
    }
}
