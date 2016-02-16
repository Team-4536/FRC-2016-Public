package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossMoat extends CommandGroup {
    
    public  CrossMoat(boolean foward) {
    	
		DriveTrapezoidProfile crossMoat;
		
    	if (foward){
        	crossMoat = new DriveTrapezoidProfile(Constants.CROSS_MOAT_DISTANCE, Constants.CROSS_MOAT_VELOCITY, Constants.CROSS_MOAT_ACCEL_LIMIT, -0.04);
        	double maxTime = crossMoat.getNeededTime() + Constants.CROSS_MOAT_EXTRA_TIME;
    		addSequential(crossMoat, maxTime);
    	}else{
        	crossMoat = new DriveTrapezoidProfile(-Constants.CROSS_MOAT_DISTANCE, Constants.CROSS_MOAT_VELOCITY, Constants.CROSS_MOAT_ACCEL_LIMIT, -0.04);
        	double maxTime = crossMoat.getNeededTime() + Constants.CROSS_MOAT_EXTRA_TIME;
    		addSequential(crossMoat, maxTime);
    	}
    	
    }
}
