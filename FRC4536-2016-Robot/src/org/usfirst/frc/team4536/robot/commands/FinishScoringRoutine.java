package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Liam
 * Right goal enter true for right, left goal enter false for left
 */
public class FinishScoringRoutine extends CommandGroup {
    
    public  FinishScoringRoutine(boolean right) {
      
    	this(right, Constants.DEFAULT_FINISHING_ANGLE);
    }
    
    public FinishScoringRoutine(boolean right, double angle) {
    	
    	if (right) {
    			
			addSequential(new TurnTrapezoidProfile(angle, Constants.TURNING_TRAPEZOID_DEFAULT_ANGULAR_SPEED, Constants.TURNING_TRAPEZOID_DEFAULT_ANGULAR_ACCELERATION));
			addSequential(new DriveTrapezoidProfile(Constants.RIGHT_SIDE_FINISHING_SCORING_DISTANCE));
	    	addSequential(new EjectBoulderAccelLimited());
    	}
    	else {
    		
    		addSequential(new TurnTrapezoidProfile(-angle, Constants.TURNING_TRAPEZOID_DEFAULT_ANGULAR_SPEED, Constants.TURNING_TRAPEZOID_DEFAULT_ANGULAR_ACCELERATION));
	    	addSequential(new EjectBoulderAccelLimited());
    	}
    }
}
