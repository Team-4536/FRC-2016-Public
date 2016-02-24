package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 */
public class DefenseAlignmentPosition extends CommandGroup {
    
    public  DefenseAlignmentPosition(int pos) {
    	
    	switch (pos) {
    	
	    	case 2:
	    		
	        	addSequential(new TurnTrapezoidProfile(Constants.DEFENSE_ALIGNMENT2_ANGLE));
	        	addSequential(new DriveTrapezoidProfile(Constants.DEFENSE_ALIGNMENT2_DISTANCE));
	        	addSequential(new TurnTrapezoidProfile(-Constants.DEFENSE_ALIGNMENT2_ANGLE));
	        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT2_TURN));
	    	break;
	    	
	    	case 3:
	    		
	        	addSequential(new TurnTrapezoidProfile(Constants.DEFENSE_ALIGNMENT3_ANGLE));
	        	addSequential(new DriveTrapezoidProfile(Constants.DEFENSE_ALIGNMENT3_DISTANCE));
	        	addSequential(new TurnTrapezoidProfile(-Constants.DEFENSE_ALIGNMENT3_ANGLE));
	        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT3_TURN));
	    	break;
	    	
	    	case 4:
	    		
	        	addSequential(new TurnTrapezoidProfile(Constants.DEFENSE_ALIGNMENT4_ANGLE));
	        	addSequential(new DriveTrapezoidProfile(Constants.DEFENSE_ALIGNMENT4_DISTANCE));
	        	addSequential(new TurnTrapezoidProfile(-Constants.DEFENSE_ALIGNMENT4_ANGLE));
	        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT4_TURN));
	    	break;
	    	
	    	case 5:
	    		
	        	addSequential(new TurnTrapezoidProfile(Constants.DEFENSE_ALIGNMENT5_ANGLE));
	        	addSequential(new DriveTrapezoidProfile(Constants.DEFENSE_ALIGNMENT5_DISTANCE));
	        	addSequential(new TurnTrapezoidProfile(-Constants.DEFENSE_ALIGNMENT5_ANGLE));
	        	addSequential(new FinishScoringRoutine(Constants.DEFENSE_ALIGNMENT5_TURN));
	    	break;
    	}
    }
}