package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CrossDefense {
    
   public static Command chooseDefense(Utilities.Defense d, boolean orientation){
	   
	   switch(d){
	   
	   case LOW_BAR:
		   
		   return new CrossLowBar(orientation);
	   
	   case MOAT:
		   
		   return new CrossMoat(orientation);
		   
	   case ROCK_WALL:
		   
		   return new CrossRockWall(orientation);

	   case ROUGH_TERRAIN:
		   
		   return new CrossRoughTerrain(orientation);
	
	   case RAMPARTS:
		   
		   return new CrossRamparts(orientation);
		   
	   default:
		   
		   return new ReleaseIntake();
	   }
	   
   }
   
}
