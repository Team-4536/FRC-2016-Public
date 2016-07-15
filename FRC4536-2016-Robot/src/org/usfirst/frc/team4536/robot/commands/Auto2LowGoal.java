package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto2LowGoal extends CommandGroup {
    
    public  Auto2LowGoal() {
    	
    	addParallel(new ReleaseIntake());
    	addSequential(new TeleopTurn(90.0));
    	addSequential(new EjectBoulderAccelLimited(), 1.0);
    	addSequential(new TeleopTurn(180.0));
    	addSequential(new DriveTrapezoidProfile(15.0, 180.0));
    	addSequential(new AutoApproachPickupBoulderStop(4.0, 180.0));
    	addSequential(new DriveTrapezoidProfile(-17, 180.0));
    	addSequential(new TeleopTurn(60.0));
    	addSequential(new EjectBoulderAccelLimited(), 2.0);
    	//addSequential(new LowBarLowGoal());
    }
}