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
    	autoChooser.addObject(" Spy Box Low Goal Auto: ", 9);
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
    	
    	classCChooser.addObject(" Move over -2", -2);
    	classCChooser.addObject(" Move over -1", -1);
    	classCChooser.addDefault(" None", 0);
    	classCChooser.addObject(" Move over 1", 1);
    	classCChooser.addObject(" Move over 2", 2);
    	SmartDashboard.putData(" Class C Chooser", classCChooser);
    	
    	int defense = (int) autoChooser.getSelected().hashCode();
    	
    	int pos = (int) defensePositionChooser.getSelected().hashCode();
    	
    	int classC = (int) classCChooser.getSelected().hashCode();
    	
    	if (pos == 1 || pos == 0) {
        	
    		//TODO Add orientation to new autoChooser
	    	switch ((int) orientationChooser.getSelected().hashCode()) {
	    	
		    	case 0:

		    		CommandBase.driveTrain.resetNavX(0.0);
		    		orientation = true;
		    	break;
		    	
		    	case 1:

		    		CommandBase.driveTrain.resetNavX(180.0);
		    		orientation = false;
		    	break;
		    	
		    	default:
		    		
		    		orientation = true;
		    	break;
	    	}	
	    	if (classC == 0){
	    		
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

					addSequential(CrossDefense.chooseDefense(Utilities.Defense.LOW_BAR, orientation));
				
				break;

				case 5:

					addSequential(CrossDefense.chooseDefense(Utilities.Defense.ROUGH_TERRAIN, orientation));
				
				break;

				case 6:

					addSequential(CrossDefense.chooseDefense(Utilities.Defense.ROCK_WALL, orientation));

				break;

				case 7:

					addSequential(CrossDefense.chooseDefense(Utilities.Defense.MOAT, orientation));
					
				break;

				case 8:

					addSequential(CrossDefense.chooseDefense(Utilities.Defense.RAMPARTS, orientation));
					
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
			}else{

        		switch (defense){
        		
        		case 4:
        			
    				new OpenClassC(Constants.CROSS_LOWBAR_DISTANCE,Constants.CROSS_LOWBAR_VELOCITY, 
    						Constants.CROSS_LOWBAR_ACCEL_LIMIT, Constants.CROSS_LOWBAR_EXTRA_TIME, 
    						Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY, orientation, classC);
        		break;
        		
    			case 5:
    				
    				new OpenClassC(Constants.CROSS_MOAT_DISTANCE, Constants.CROSS_MOAT_VELOCITY,
    						Constants.CROSS_MOAT_ACCEL_LIMIT, Constants.CROSS_MOAT_EXTRA_TIME,
    						Constants.CROSS_MOAT_GYRO_PROPORTIONALITY, orientation, classC);
    			break;
    			
    			case 6:
    			
    				new OpenClassC(Constants.CROSS_ROCKWALL_DISTANCE, Constants.CROSS_RAMPARTS_VELOCITY,
    						Constants.CROSS_ROCKWALL_ACCEL_LIMIT, Constants.CROSS_ROCKWALL_EXTRA_TIME,
    						Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY, orientation, classC);
    			break;
    			
    			case 7:
    				
    				new OpenClassC(Constants.CROSS_ROUGHTERRAIN_DISTANCE, Constants.CROSS_ROUGHTERRAIN_VELOCITY,
    						Constants.CROSS_ROCKWALL_ACCEL_LIMIT, Constants.CROSS_ROUGHTERRAIN_EXTRA_TIME,
    						Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY, orientation, classC);
    			break;
    			
    			case 8:
    				
    				new OpenClassC(Constants.CROSS_RAMPARTS_DISTANCE, Constants.CROSS_RAMPARTS_VELOCITY,
    						Constants.CROSS_RAMPARTS_ACCEL_LIMIT, Constants.CROSS_RAMPARTS_EXTRA_TIME,
    						Constants.CROSS_RAMPARTS_GYRO_PROPORTIONALITY, orientation, classC);
    			break;
    			
    			default:
    				
    				new OpenClassC(Constants.CROSS_LOWBAR_DISTANCE,Constants.CROSS_LOWBAR_VELOCITY, 
    						Constants.CROSS_LOWBAR_ACCEL_LIMIT, Constants.CROSS_LOWBAR_EXTRA_TIME, 
    						Constants.TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY, orientation, classC);
        		break;
        		}	
			}
	    }else{

			//System.out.println("Auto Cross And Score");
    		addSequential(new CrossNScore(defense, pos));

	    }
    }  	
}	