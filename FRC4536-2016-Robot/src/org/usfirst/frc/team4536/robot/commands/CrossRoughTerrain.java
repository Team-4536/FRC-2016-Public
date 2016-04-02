package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Sheila
 * This command group crosses the rough terrain
 * 
 * @param forward	are we crossing this defense forward(true) or backward(false)?
 */
public class CrossRoughTerrain extends CommandGroup {
    
    public  CrossRoughTerrain(boolean forward) {
    	
    	addParallel(new ReleaseIntake());
    	
    	DriveTrapezoidProfile crossRoughTerrain;
    	
    	if (forward) {
    		crossRoughTerrain = new DriveTrapezoidProfile(Constants.CROSS_ROUGHTERRAIN_DISTANCE, Constants.CROSS_ROUGHTERRAIN_VELOCITY, Constants.CROSS_ROUGHTERRAIN_ACCEL_LIMIT);
    		double maxTime = crossRoughTerrain.getNeededTime() + Constants.CROSS_ROUGHTERRAIN_EXTRA_TIME;
    		addSequential(crossRoughTerrain, maxTime);
    	} else {
    		crossRoughTerrain = new DriveTrapezoidProfile(-Constants.CROSS_ROUGHTERRAIN_DISTANCE, Constants.CROSS_ROUGHTERRAIN_VELOCITY, Constants.CROSS_ROUGHTERRAIN_ACCEL_LIMIT);
    		double maxTime = crossRoughTerrain.getNeededTime() + Constants.CROSS_ROUGHTERRAIN_EXTRA_TIME;
    		addSequential(crossRoughTerrain, maxTime);
    	}
    }
    
	public CrossRoughTerrain() {
		this(true);
	}
}
