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
    	
    	//TODO Remove Debug printout
    	System.out.println("Cross and Score Entered.");
    	
		switch (defense) {
		
			case 5:
				
				addSequential(new CrossDefense(Utilities.Defense.ROUGH_TERRAIN, orientation));
			break;
			
			case 6:
				
				addSequential(new CrossDefense(Utilities.Defense.ROCK_WALL, orientation));
			break;
	
			case 7:
				
				addSequential(new CrossDefense(Utilities.Defense.MOAT, orientation));
			break;
				
			case 8:
				
				addSequential(new CrossDefense(Utilities.Defense.RAMPARTS, orientation));
				
			break;
			
			default: 
				
				addSequential(new ReleaseIntake());
			break;
		}
		//TODO Remove Debug printout
		System.out.println("Post Defense Crossing Reached");
		addSequential(new DefenseAlignmentPosition(pos));
    }
}
