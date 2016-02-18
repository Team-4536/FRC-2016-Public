package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 *This command group reaches the outerworks
 */
public class PickUpBoulder extends CommandGroup {
    
    public  PickUpBoulder() {
    	
    	addSequential(new IntakeBoulder(), Constants.PICK_UP_BALL_TIME_OUT);
    }
}