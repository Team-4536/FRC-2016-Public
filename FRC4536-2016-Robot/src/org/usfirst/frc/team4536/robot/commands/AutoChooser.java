package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *@author Liam
 *This chooses the autonomous mode which will be executed for the duration of the match.
 */
public class AutoChooser extends CommandBase {
	
	SendableChooser autoChooser;
	
	boolean forward = true;

    public AutoChooser() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis)
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    
    	
    	/*-----AutoChooser Options----*/
    	
    	autoChooser.addDefault("DoNothing", 0);
    	autoChooser.addObject("Reach Outer Works",  1);
    	autoChooser.addObject("PickUpBoulder", 2);
    	autoChooser.addObject("CrossLowBar", 3);
    	autoChooser.addObject("CrossRoughTerrain", 4);
    	autoChooser.addObject("CrossRockWall", 5);
    	autoChooser.addObject("CrossMoat", 6);
    	SmartDashboard.putData("Auto Chooser", autoChooser);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	switch ((int) autoChooser.getSelected().hashCode()) {
    	
    		case 0:
    			
    			new DoNothing().start();
    			
    		break;
    			
    		case 1:
    			
    			new ReachOuterWorks().start();
    			
    		break;
    		
    		case 2:
    			
    			new PickUpBoulder().start();
    			
    		break;
    	
    		case 3:
    			
    			new CrossDefense(0, forward);
    			
    		break;
    	
    		
    		case 4:
    			
    			new CrossDefense(1, forward);
    			
    		break;
    		
    		case 5:
    			
    			new CrossDefense(2, forward);
    			
    		break;
    		
    		case 6:
    			
    			new CrossDefense(3, forward);
    			
    		break;
    		
    		default: 
    			
    			driveTrain.arcadeDrive(0.0, 0.0);
    		break;
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
