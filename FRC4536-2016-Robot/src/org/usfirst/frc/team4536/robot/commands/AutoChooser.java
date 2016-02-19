package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *@author Liam
 *This chooses the autonomous mode which will be executed for the duration of the match.
 */
public class AutoChooser extends CommandBase {
	
	SendableChooser autoChooser;

    public AutoChooser() {
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    	
    	/*-----Selectable Chooser Options----*/
    	
    	autoChooser.addDefault(" DoNothing", 0);
    	autoChooser.addObject(" Reach Outer Works",  1);
    	autoChooser.addObject(" PickUpBoulder", 2);
    	autoChooser.addObject(" CrossLowBar", 3);
    	autoChooser.addObject(" CrossRoughTerrain", 4);
    	autoChooser.addObject(" CrossRockWall", 5);
    	autoChooser.addObject(" CrossMoat", 6);
    	autoChooser.addObject(" CrossRamparts", 7);
    	SmartDashboard.putData(" Auto Chooser", autoChooser);
    }
    
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
    			
    			new CrossLowBar(true).start();
    		break;
    		
    		case 4:
    			
    			new CrossRoughTerrain(true).start();
    		break;
    		
    		case 5:
    			
    			new CrossRockWall(true).start();
    		break;
    		
    		case 6:
    			
    			new CrossMoat(true).start();
    		break;

    		case 7:
    			
    			new CrossRamparts(true).start();
    		
    		default: 
    			
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
