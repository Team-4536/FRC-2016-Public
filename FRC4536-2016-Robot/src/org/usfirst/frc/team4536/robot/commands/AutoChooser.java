package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.commands.*;

/**
 *@author Liam
 *auto chooser chooses the autonomous mode which will be executed for the duration of the match.
 *orientation chooses whether the robot goes over the defense forwards or backwards.
 */
public class AutoChooser extends CommandBase {
	
	SendableChooser autoChooser;
	SendableChooser orientationChooser; //Picks whether the robot is going forward or backward over a defense
	SendableChooser defensePositionChooser; // Picks which defense position the defense you are crossing is
	
	private boolean orientation = true; // true is forward, false is backward
	
	boolean forward = true;

    public AutoChooser() {
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    	orientationChooser = new SendableChooser();
    	defensePositionChooser = new SendableChooser();
    
    	
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
    	autoChooser.addObject(" 2 Goal Spy Bot Auto: ", 11);
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
    }
    
    protected void initialize() {
    	
    	int defense = (int) autoChooser.getSelected().hashCode();
    	
    	int pos = (int) defensePositionChooser.getSelected().hashCode();
    	
    	if (pos == 1 || pos == 0) {
    	
	    	switch ((int) orientationChooser.getSelected().hashCode()) {
	    	
		    	case 0:

		    		driveTrain.resetNavX(0.0);
		    		orientation = true;
		    	break;
		    	
		    	case 1:

		    		driveTrain.resetNavX(180.0);
		    		orientation = false;
		    	break;
		    	
		    	default:
		    		
		    		orientation = true;
		    	break;
	    	}	
	
			switch (defense) {
			
				case 0:
					
					new ReleaseIntake().start();
				break;
					
				case 1:
					
					new DoNothing().start();
				break;
				
				case 2:
					
					new ReachOuterWorks(orientation).start();
					
				break;
			
				case 3:
					
					new PickUpBoulder().start();
				break;
				
				case 4:
					
					new CrossDefense(Utilities.Defense.LOW_BAR, orientation);
				break;
				
				case 5:
					
					new CrossDefense(Utilities.Defense.ROUGH_TERRAIN, orientation);
				break;
				
				case 6:
					
					new CrossDefense(Utilities.Defense.ROCK_WALL, orientation);
				break;
		
				case 7:
					
					new CrossDefense(Utilities.Defense.MOAT, orientation);
				break;
					
				case 8:
					
					new CrossDefense(Utilities.Defense.RAMPARTS, orientation);
					
				break;
				
				case 9:

					driveTrain.resetNavX(Constants.SPY_BOT_ANGLE);
					new SpyBotLowGoal().start();
				break;
				
				case 10:
					
					new LowBarLowGoal().start();
				break;
				
				default: 
					
					new ReleaseIntake().start();
					driveTrain.arcadeDrive(0.0, 0.0);
				break;
			}
	    }
    	else {
    		
    		driveTrain.resetNavX(180.0);
    		new CrossNScore(defense, pos).start();
    	}
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}