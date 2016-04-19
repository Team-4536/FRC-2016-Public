package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossPortcullis extends CommandGroup {
    
    public  CrossPortcullis() {
    	
       addParallel(new ReleaseIntake());
       
       addSequential(new DriveTrapezoidProfile(8.3, 9.0, 4.0));
       
       addParallel(new DriveTrapezoidProfile(5.0, 1.0, 1.0, -0.03, 0.01));
       
       addSequential(new RunIntake(1.0, 1.0));
       
       addParallel(new DriveTrapezoidProfile(9.0, 9.0, 4.0));
    }
}
