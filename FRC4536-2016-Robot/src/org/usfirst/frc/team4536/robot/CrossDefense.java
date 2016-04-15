package org.usfirst.frc.team4536.robot;

import org.usfirst.frc.team4536.robot.Utilities.Defense;
import org.usfirst.frc.team4536.robot.commands.CrossLowBar;
import org.usfirst.frc.team4536.robot.commands.CrossMoat;
import org.usfirst.frc.team4536.robot.commands.CrossRamparts;
import org.usfirst.frc.team4536.robot.commands.CrossRockWall;
import org.usfirst.frc.team4536.robot.commands.CrossRoughTerrain;
import org.usfirst.frc.team4536.robot.commands.ReleaseIntake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Audrey
 */
public class CrossDefense {
    
   public static Command chooseDefense(Defense d, boolean orientation){
	   
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
