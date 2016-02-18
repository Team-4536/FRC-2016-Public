package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 
 */
public class CrossLowBar extends CommandGroup {
    
    public  CrossLowBar(boolean foward) {
    	
		DriveTrapezoidProfile crossLowBar;
		
    	if (foward){
        	crossLowBar = new DriveTrapezoidProfile(Constants.CROSS_LOWBAR_DISTANCE, Constants.CROSS_LOWBAR_VELOCITY, Constants.CROSS_LOWBAR_ACCEL_LIMIT);
        	double maxTime = crossLowBar.getNeededTime() + Constants.CROSS_LOWBAR_EXTRA_TIME;
    		addSequential(crossLowBar, maxTime);
    	}else{
        	crossLowBar = new DriveTrapezoidProfile(-Constants.CROSS_LOWBAR_DISTANCE, Constants.CROSS_LOWBAR_VELOCITY, Constants.CROSS_LOWBAR_ACCEL_LIMIT);
        	double maxTime = crossLowBar.getNeededTime() + Constants.CROSS_LOWBAR_EXTRA_TIME;
    		addSequential(crossLowBar, maxTime);
    	}
    	
    }
}
