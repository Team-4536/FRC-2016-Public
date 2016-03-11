package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.Utilities.Defense;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossDefense(){
    
   public static Command chooseDefense(Utilities.Defense d){
	   
	   switch(defenseEnum){
	   
	   case 0:
		   
		   return new CrossLowBar();
	   
		   break;
	   
	   case 1:
		   
		   return new CrossMoat();
		   
		   break;
		   
	   case 2:
		   
		   return new CrossRockWall();
		   
		   break;
		   
	   case 3:
		   
		   return new CrossRoughTerrain();
	
		   break;
		   
	   case 4:
		   
		   return new CrossRamparts();
		   
		   break;
	   }
	   
   }
   
}
