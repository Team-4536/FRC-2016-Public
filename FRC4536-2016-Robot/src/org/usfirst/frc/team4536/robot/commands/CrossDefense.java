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
		   
		   //System.out.println("CrossDefense: Low Bar");
		   return new CrossLowBar(orientation);
	   
	   case MOAT:

		   //System.out.println("CrossDefense: Moat");
		   return new CrossMoat(orientation);
		   
	   case ROCK_WALL:

		   //System.out.println("CrossDefense: Rock Wall");
		   return new CrossRockWall(orientation);

	   case ROUGH_TERRAIN:

		   //System.out.println("CrossDefense: Rough Terrain");
		   return new CrossRoughTerrain(orientation);
	
	   case RAMPARTS:

		   //System.out.println("CrossDefense: Ramparts");
		   return new CrossRamparts(orientation);
		   
	   default:

		   //System.out.println("CrossDefense: Release Intake");
		   return new ReleaseIntake();
	   }
	   
   }
   
}
