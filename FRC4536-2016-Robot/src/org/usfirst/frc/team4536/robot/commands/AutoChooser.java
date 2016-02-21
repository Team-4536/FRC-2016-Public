package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.commands.*;

/**
 *@author Liam
 *This chooses the autonomous mode which will be executed for the duration of the match.
 */
public class AutoChooser extends CommandBase {
	
	SendableChooser autoChooser;
	
	boolean forward = true;

    public AutoChooser() {
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    
    	
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
    }
    
    protected void initialize() {
    	
    	switch ((int) autoChooser.getSelected().hashCode()) {
    	
    		case 0:
    			
    			new ReleaseIntake().start();
    		break;
    			
    		case 1:
    			
    			new DoNothing().start();
    		break;
    		
    		case 2:
    			
    			new ReachOuterWorks().start();
    			
    		break;
    	
    		case 3:
    			
    			new PickUpBoulder().start();
    		break;
    		
    		case 4:
    			
    			new CrossDefense(0, true);
    		break;
    		
    		case 5:
    			
    			new CrossDefense(1, true);
    		break;
    		
    		case 6:
    			
    			new CrossDefense(2, true);
    		break;

    		case 7:
    			
    			new CrossDefense(3, true);
    		break;
    			
    		case 8:
    			
    			new CrossDefense(4, true);
    			
    		break;
    		
    		case 9:
    			
    			new SpyBoxLowGoal().start();
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