package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.commands.DefenseAlignmentPosition;

/**
 *@author Liam
 */
public class CrossNScore extends CommandGroup {
	
	private boolean orientation;
    
    public  CrossNScore(int pos) {
    	
    	addSequential(new DefenseAlignmentPosition(pos));
    }
}
