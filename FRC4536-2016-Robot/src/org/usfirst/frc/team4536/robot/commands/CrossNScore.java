package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.commands.DefenseAlignmentPosition;

/**
 *
 */
public class CrossNScore extends CommandGroup { 
	
	private boolean orientation;
    
    public  CrossNScore(int defense, int pos) {
    	
    	orientation = false;
    	switch (defense) {
    	
    	case 5:
    		
	    	addSequential(new CrossRoughTerrain(orientation));
	    	addSequential(new DefenseAlignmentPosition(pos));
    	
    	break;
    	
    	case 6:
    		
    		addSequential(new CrossRockWall(orientation));
    		addSequential(new DefenseAlignmentPosition(pos));
    	break;
    	
    	case 7:
    		
    		addSequential(new CrossMoat(orientation));
	    	addSequential(new DefenseAlignmentPosition(pos));
	    break;
	    
    	case 8:
    		
    		addSequential(new CrossRamparts(orientation));
	    	addSequential(new DefenseAlignmentPosition(pos));
	    break;
    	
    	default:
    		
    		addSequential(new DoNothing());
    		
    	break;
    	}
    }
}
