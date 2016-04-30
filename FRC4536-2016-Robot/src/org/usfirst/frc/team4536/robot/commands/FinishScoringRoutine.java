package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Liam
 * Right goal enter true for right, left goal enter false for left
 */
public class FinishScoringRoutine extends CommandGroup {
    

    public FinishScoringRoutine(boolean right) {
    	
    	if (right) {
    			
			addSequential(new TeleopTurn(Constants.RIGHT_LOW_GOAL_ANGLE, 240, 180));
	    	addSequential(new DriveTrapezoidProfile(2.0));
	    	addSequential(new EjectBoulderAccelLimited());
    	}
    	else {
    		
    		addSequential(new TeleopTurn(Constants.LEFT_LOW_GOAL_ANGLE, 240, 180));
    		addSequential(new DriveTrapezoidProfile(1.5));
    		addSequential(new EjectBoulderAccelLimited());
	    	
    	}
    }
}
