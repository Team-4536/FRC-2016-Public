package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 */
public class DefenseAlignmentPosition extends CommandGroup {
    
    public  DefenseAlignmentPosition(int pos) {
    	
    	switch (pos) {
    	
	    	case 2:
	    		
	        	addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.DEFENSE_ALIGNMENT2_ANGLE), Constants.DEFENSE_ALIGNMENT2_ANGLE));
	        	addSequential(new DriveProfile(new TrapezoidProfile(Constants.DEFENSE_ALIGNMENT2_DISTANCE), Constants.DEFENSE_ALIGNMENT2_ANGLE));
	        	
	        	if (Constants.DEFENSE_ALIGNMENT2_ULTRA) {
	        		
	        		addSequential(new DriveProfile(new TurningTrapezoidProfile(180.0), 180.0));
	        		//TODO add ultra code here
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT2_TURN));
	        	}
	        	else {
	        		
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT2_TURN));
	        	}
	    	break;
	    	
	    	case 3:
	    		
	        	addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.DEFENSE_ALIGNMENT3_ANGLE), Constants.DEFENSE_ALIGNMENT3_ANGLE));
	        	addSequential(new DriveProfile(new TrapezoidProfile(Constants.DEFENSE_ALIGNMENT3_DISTANCE), Constants.DEFENSE_ALIGNMENT3_ANGLE));
	        	
	        	if (Constants.DEFENSE_ALIGNMENT3_ULTRA) {
	        		
	        		//TODO add ultra code here
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT3_TURN));
	        	}
	        	else {
	        		
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT3_TURN));
	        	}
	    	break;
	    	
	    	case 4:
	    		
	        	addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.DEFENSE_ALIGNMENT4_ANGLE), Constants.DEFENSE_ALIGNMENT4_ANGLE));
	        	addSequential(new DriveProfile(new TrapezoidProfile(Constants.DEFENSE_ALIGNMENT4_DISTANCE), Constants.DEFENSE_ALIGNMENT4_ANGLE));
	        	
	        	if (Constants.DEFENSE_ALIGNMENT4_ULTRA) {
	        		
	        		//TODO add ultra code here
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT4_TURN));
	        	}
	        	else {
	        		
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT4_TURN));
	        	}
	    	break;
	    	
	    	case 5:
	    		
	        	addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.DEFENSE_ALIGNMENT5_ANGLE), Constants.DEFENSE_ALIGNMENT5_ANGLE));
	        	addSequential(new DriveProfile(new TrapezoidProfile(Constants.DEFENSE_ALIGNMENT5_DISTANCE), Constants.DEFENSE_ALIGNMENT5_ANGLE));
	        	
	        	if (Constants.DEFENSE_ALIGNMENT2_ULTRA) {
	        		
	        		//TODO add ultra code here
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT5_TURN));
	        	}
	        	else {
	        		
		        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT5_TURN));
	        	}
	    	break;
    	}
    }
}
