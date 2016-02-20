package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossDefense extends CommandGroup {
    
    public  CrossDefense(int defense, boolean forward) {
    	
    	Utilities.Defense defenseEnum = Utilities.Defense.values()[defense];
    	
    	switch(defenseEnum){
      
    	case LOW_BAR:
    	  
    		new CrossLowBar(forward).start();
    		
    	break;
    	 
    	case MOAT:
    		
    		new CrossMoat(forward).start();
    		
    	break;
    	
    	case ROCK_WALL:
    		
    		new CrossRockWall(forward).start();
    		
    	break;
    	
    	case ROUGH_TERRAIN:
    		
    		new CrossRoughTerrain(forward).start();
    		
    	break;
    	
    	case RAMPARTS:
    		
    		new CrossRamparts(forward).start();
    		
    	break;
    	
    	default:
    		
    		new DoNothing().start();
    		
    	break;
      }
    }
}
