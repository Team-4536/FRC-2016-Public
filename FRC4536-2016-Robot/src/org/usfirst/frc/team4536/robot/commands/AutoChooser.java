package org.usfirst.frc.team4536.robot.commands;

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
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    
    	
    	/*-----AutoChooser Options----*/
    	
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
    			
    			new CrossDefense(0, true);
    			
    		break;
    		
    		case 4:

    			new CrossDefense(1, true);

    		break;
    		
    		case 5:
    			
    			new CrossDefense(2, true);
    			
    		break;
    		
    		case 6:
    			
    			new CrossDefense(3, true);
    			
    		break;

    		case 7:
    			
    			new CrossDefense(4, true);
    		
    		default: 
    			
    			new DoNothing().start();
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
