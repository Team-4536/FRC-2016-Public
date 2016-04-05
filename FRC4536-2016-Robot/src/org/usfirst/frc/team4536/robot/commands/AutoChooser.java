package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.CrossDefense;
import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4536.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team4536.robot.commands.*;

/**
 *@author Liam
 *auto chooser chooses the autonomous mode which will be executed for the duration of the match.
 *orientation chooses whether the robot goes over the defense forwards or backwards.
 */
public class AutoChooser extends CommandGroup {
	
	SendableChooser autoChooser;
	SendableChooser orientationChooser; //Picks whether the robot is going forward or backward over a defense
	SendableChooser defensePositionChooser; // Picks which defense position the defense you are crossing is
	SendableChooser classCChooser; //Picks how many defenses the robot is going to move over after it crosses
	
	private boolean orientation = true; // true is forward, false is backward
	
	boolean forward = true;
	
    public AutoChooser() {
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    	orientationChooser = new SendableChooser();
    	defensePositionChooser = new SendableChooser();
    	classCChooser = new SendableChooser();
    	
    	/*-----AutoChooser Options----*/
    	
    	autoChooser.addDefault(" Release Intake", 0);
    	autoChooser.addObject(" DoNothing", 1);
    	autoChooser.addObject(" Reach Outer Works",  2);
    	autoChooser.addObject(" PickUpBoulder", 3);
    	autoChooser.addObject(" CrossLowBar", 4);
    	autoChooser.addObject(" CrossRoughTerrain", 5);
    	autoChooser.addObject(" CrossRockWall", 6);
    	autoChooser.addObject(" CrossMoat", 7);
    	autoChooser.addObject(" CrossRamparts", 8);
    	autoChooser.addObject(" Spy Bot Low Goal Auto: ", 9);
    	autoChooser.addObject(" LowBarLowGoal", 10);
    	SmartDashboard.putData(" Auto Chooser", autoChooser);
    	
    	orientationChooser.addDefault(" Forwards", 0);
    	orientationChooser.addObject(" Backwards", 1);
    	SmartDashboard.putData(" Orientation Chooser", orientationChooser);
    	
    	defensePositionChooser.addDefault(" None", 0);
    	defensePositionChooser.addObject(" Any Other Auto", 1);
    	defensePositionChooser.addObject(" Position 2", 2);
    	defensePositionChooser.addObject(" Position 3", 3);
    	defensePositionChooser.addObject(" Position 4", 4);
    	defensePositionChooser.addObject(" Position 5", 5);
    	SmartDashboard.putData(" Defense Position Chooser", defensePositionChooser);
    	
    	classCChooser.addObject(" Move over left 2 (driver perspective)", -2);
    	classCChooser.addObject(" Move over left 1 (driver perspective)", -1);
    	classCChooser.addDefault(" None", 0);
    	classCChooser.addObject(" Move over right 1 (driver perspective)", 1);
    	classCChooser.addObject(" Move over right 2 (driver perspective)", 2);
    	SmartDashboard.putData(" Class C Chooser", classCChooser);
    	
    	int defense = (int) autoChooser.getSelected().hashCode();
    	
    	int pos = (int) defensePositionChooser.getSelected().hashCode();
    	
    	int classC = (int) classCChooser.getSelected().hashCode();
    	
    	switch ((int) orientationChooser.getSelected().hashCode()) {
    	
	    	case 0:
	
	    		CommandBase.driveTrain.resetNavX(0.0);
	    		System.out.println(CommandBase.driveTrain.getOffset());
	    		orientation = true;
	    	break;
	    	
	    	case 1:
	
	    		CommandBase.driveTrain.resetNavX(180.0);
	    		System.out.println(CommandBase.driveTrain.getOffset());
	    		orientation = false;
	    	break;
	    	
	    	default:
	    		
	    		orientation = true;
	    		System.out.println(CommandBase.driveTrain.getOffset());
	    	break;
		}
	
		switch (defense) {
		
			case 0:
			
				addSequential(new ReleaseIntake());
			
			break;
	
			case 1:
	
				addSequential(new DoNothing());
	
			break;
	
			case 2:
	
				addSequential(new ReachOuterWorks(orientation));
	
			break;
		
			case 3:
	
				addSequential(new PickUpBoulder());
			
			break;
	
			case 4:
	
				addSequential(new CrossLowBar(orientation));
			
			break;
	
			case 5:
	
				addSequential(new CrossRoughTerrain(orientation));
			
			break;
	
			case 6:
	
				addSequential(new CrossRockWall(orientation));
	
			break;
	
			case 7:
	
				addSequential(new CrossMoat(orientation));
				
			break;
	
			case 8:
	
				addSequential(new CrossRamparts(orientation));
				
			break;
	
			case 9:
				
				CommandBase.driveTrain.resetNavX(135.0);
				addSequential(new SpyBotLowGoal());
				
			break;
	
			case 10:
	
				addSequential(new LowBarLowGoal());
				
			break;
	
			default: 
	
				addSequential(new ReleaseIntake());
			
			break;
		}
    	
    	if (pos == 1 || pos == 0) {
	    	
	    	//initial mode selection
	    	//ClassC if crossing
	    	if (defense >= 4 && defense <= 8) { // crossing defense
	    		
	    		if (classC != 0) {
	    			
	    			addSequential(new OpenClassC(orientation, classC));
        		}	
	    	}
	    }
    	else{

			//System.out.println("Auto Cross And Score");
    		if (defense >=5 && defense <= 8) {
    			
    			addSequential(new CrossNScore(pos));
    		}
	    }
    }  	
}	