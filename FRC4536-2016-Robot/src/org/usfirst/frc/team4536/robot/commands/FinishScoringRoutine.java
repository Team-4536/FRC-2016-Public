package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Liam
 * Right goal enter true for right, left goal enter false for left
 */
public class FinishScoringRoutine extends CommandGroup {
    
    public  FinishScoringRoutine(boolean right) {
      
    	this(right, 120);
    }
    
    public FinishScoringRoutine(boolean right, double angle) {
    	
    	if (right) {
    		
    		//TODO remove debug printout
        	System.out.println("Finish Scoring Routine Reached");
	    	addSequential(new TurnTrapezoidProfile(angle, 240, 180));
	    	addSequential(new EjectBoulderAccelLimited());
    	}
    	else {
    		
    		//TODO remove debug printout
        	System.out.println("Finish Scoring Routine Reached");
    		addSequential(new TurnTrapezoidProfile(-angle, 240, 180));
	    	addSequential(new EjectBoulderAccelLimited());
    	}
    }
}
