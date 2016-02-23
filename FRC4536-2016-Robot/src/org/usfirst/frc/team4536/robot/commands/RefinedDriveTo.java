package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RefinedDriveTo extends CommandGroup {
    
    public  RefinedDriveTo() {
    	addSequential(new UpdateDriveTrain());
    	addSequential(new DriveTo());
    }
}
