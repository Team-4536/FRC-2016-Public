package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.commands.*;

/**
 *@author Liam
 *This chooses the autonomous mode which will be executed for the duration of the match.
 */
public class AutoChooser extends CommandGroup {
	
	SendableChooser autoChooser;

    public AutoChooser() {
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    	
    	/*-----Selectable Chooser Options----*/
    	
    	autoChooser.addDefault(" Release Intake", 0);
    	autoChooser.addObject(" DoNothing", 1);
    	autoChooser.addObject(" Reach Outer Works",  2);
    	autoChooser.addObject(" PickUpBoulder", 3);
    	autoChooser.addObject(" CrossLowBar", 4);
    	autoChooser.addObject(" CrossRoughTerrain", 5);
    	autoChooser.addObject(" CrossRockWall", 6);
    	autoChooser.addObject(" CrossMoat", 7);
    	autoChooser.addObject(" CrossRamparts", 8);
    	SmartDashboard.putData(" Auto Chooser", autoChooser);
    }
    
    protected void initialize() {
    	
    	switch ((int) autoChooser.getSelected().hashCode()) {
    		
	    	case 0:
	    		
	    		addSequential(new ReleaseIntake());
	    	break;
	    	
    		case 1:
    			
    			addSequential(new DoNothing());
    		break;
    			
    		case 2:
    			
    			addSequential(new ReachOuterWorks());
    		break;
    		
    		case 3:
    			
    			addSequential(new PickUpBoulder());
    		break;
    	
    		case 4:
    			
    			addSequential(new CrossLowBar(true));
    		break;
    		
    		case 5:
    			
    			addSequential( new CrossRoughTerrain(true));
    		break;
    		
    		case 6:
    			
    			addSequential(new CrossRockWall(true));
    		break;
    		
    		case 7:
    			
    			addSequential(new CrossMoat(true));
    		break;

    		case 8:
    			
    			addSequential(new CrossRamparts(true));
    		
    		default: 
    			
    			addSequential(new ReleaseIntake());
    		break;
    	}
    	
    }
    
    protected void execute() { // Executes sequence
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
