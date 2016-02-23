package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpyBotLowGoal extends CommandGroup {
    
    public  SpyBotLowGoal() {
    	
    	addParallel(new ReleaseIntake());
    	addSequential(new DriveTrapezoidProfile(4.5, 10, 4));
    	addSequential(new TurnTrapezoidProfile(-75, 150, 90));
    	addSequential(new DriveTrapezoidProfile(5.3, 10, 4));
    	addSequential(new EjectBoulderAccelLimited());
    }
}