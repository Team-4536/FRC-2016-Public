package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto2LowGoal extends CommandGroup {
    
    public  Auto2LowGoal() {
    	
    	addParallel(new ReleaseIntake());
    	addSequential(new DriveProfile(new TurningTrapezoidProfile(90.0)));
    	addSequential(new EjectBoulderAccelLimited(), 1.0);
    	addSequential(new DriveProfile(new TurningTrapezoidProfile(180.0)));
    	addSequential(new DriveProfile(new TrapezoidProfile(15.0), 180.0));
    	addSequential(new AutoApproachPickupBoulderStop(4.0, 180.0));
    	addSequential(new DriveProfile(new TrapezoidProfile(-17.0), 180.0));
    	addSequential(new DriveProfile(new TurningTrapezoidProfile(60.0)));
    	addSequential(new EjectBoulderAccelLimited(), 2.0);
    	//addSequential(new LowBarLowGoal());
    }
}
