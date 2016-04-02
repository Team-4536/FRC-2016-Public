package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Sheila
 * 
 * @param forward	are we crossing this defense forward(true) or backward(false)?
 */
public class CrossRamparts extends CommandGroup {
    
	public  CrossRamparts(boolean forward) {
		
			addParallel(new ReleaseIntake());
	    	
			DriveTrapezoidProfile crossRamparts;
			
	    	if (forward){
	        	crossRamparts = new DriveTrapezoidProfile(Constants.CROSS_RAMPARTS_DISTANCE, Constants.CROSS_RAMPARTS_VELOCITY, Constants.CROSS_RAMPARTS_ACCEL_LIMIT, Constants.CROSS_RAMPARTS_GYRO_PROPORTIONALITY);
	        	double maxTime = crossRamparts.getNeededTime() + Constants.CROSS_RAMPARTS_EXTRA_TIME;
	    		addSequential(crossRamparts, maxTime);
	    	}else{
	        	crossRamparts = new DriveTrapezoidProfile(-Constants.CROSS_RAMPARTS_DISTANCE, Constants.CROSS_RAMPARTS_VELOCITY, Constants.CROSS_RAMPARTS_ACCEL_LIMIT, Constants.CROSS_RAMPARTS_GYRO_PROPORTIONALITY);
	        	double maxTime = crossRamparts.getNeededTime() + Constants.CROSS_RAMPARTS_EXTRA_TIME;
	    		addSequential(crossRamparts, maxTime);
	    	}
	}
	
	
	public CrossRamparts() {
		this(true);
	}
}
