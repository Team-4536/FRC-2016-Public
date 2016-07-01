package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoApproachPickupBoulder extends CommandGroup {
    
    public  AutoApproachPickupBoulder() {

    	addSequential(new BraceAgainstWall(4, 1, 1,
											Constants.DEFAULT_CROSSING_GYRO_PROPORTIONALITY, CommandBase.driveTrain.getAngle(),
											0.15));
    	addSequential(new IntakeCurrent());
    }
}
