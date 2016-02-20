package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 *This command group reaches the outerworks
 */
public class ReachOuterWorks extends CommandGroup {
    
    public  ReachOuterWorks(boolean forward) {
    	
    	addSequential(new ReleaseIntake());
    	
    	if (forward) {
    		addSequential(new DriveTrapezoidProfile(Constants.REACH_DEFENSE_DISTANCE, Constants.REACH_DEFENSE_VELOCITY, Constants.REACH_DEFENSE_ACCELERATION));
    	}
    	else {    		
    		addSequential(new DriveTrapezoidProfile(-Constants.REACH_DEFENSE_DISTANCE, Constants.REACH_DEFENSE_VELOCITY, Constants.REACH_DEFENSE_ACCELERATION));
    	}
    }
    
	public ReachOuterWorks() {
		
		this(true);
	}
}
