package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Liam
 * Right goal enter true for right, left goal enter false for left
 */
public class FinishScoringRoutine extends CommandGroup {
    

    public FinishScoringRoutine(boolean right) {
    	
    	if (right) {
    			
			addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.RIGHT_LOW_GOAL_ANGLE, 240, 180), Constants.RIGHT_LOW_GOAL_ANGLE));
	    	addSequential(new DriveProfile(new TrapezoidProfile(2.0), Constants.RIGHT_LOW_GOAL_ANGLE));
	    	addSequential(new EjectBoulderAccelLimited());
    	}
    	else {
    		
    		addSequential(new DriveProfile(new TurningTrapezoidProfile(Constants.LEFT_LOW_GOAL_ANGLE, 240, 180), Constants.LEFT_LOW_GOAL_ANGLE));
    		addSequential(new DriveProfile(new TrapezoidProfile(1.5), Constants.LEFT_LOW_GOAL_ANGLE));
    		addSequential(new EjectBoulderAccelLimited());
	    	
    	}
    }
}
