package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Noah
 *
 */
public class PickUpBoulder extends CommandGroup {
    
    public  PickUpBoulder() {
    	
    	addSequential(new ReleaseIntake());
    	addSequential(new IntakeBallAccelLimited(), Constants.PICK_UP_BALL_TIME_OUT);
    }
}