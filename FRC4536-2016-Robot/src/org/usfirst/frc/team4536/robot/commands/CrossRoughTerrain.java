package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;

/**
 * @author Audrey
 * This command group crosses the rough terrain
 * 
 * @param forward	are we crossing this defense forward(true) or backward(false)?
 */
public class CrossRoughTerrain extends CommandGroup {
    
    public  CrossRoughTerrain(boolean forward) {
    	
    	addParallel(new ReleaseIntake());
    	
    	DriveProfile crossRoughTerrain;
    	
    	if (forward) {
    		crossRoughTerrain = new DriveProfile(new TrapezoidProfile(Constants.CROSS_ROUGHTERRAIN_DISTANCE, Constants.CROSS_ROUGHTERRAIN_VELOCITY, Constants.CROSS_ROUGHTERRAIN_ACCEL_LIMIT));
    		double maxTime = crossRoughTerrain.getNeededTime() + 1;
    		addSequential(crossRoughTerrain, maxTime);
    	} else {
    		crossRoughTerrain = new DriveProfile(new TrapezoidProfile(-Constants.CROSS_ROUGHTERRAIN_DISTANCE, Constants.CROSS_ROUGHTERRAIN_VELOCITY, Constants.CROSS_ROUGHTERRAIN_ACCEL_LIMIT));
    		double maxTime = crossRoughTerrain.getNeededTime() + 1;
    		addSequential(crossRoughTerrain, maxTime);
    	}
    }
    
    /**
     * @author Noah
     * Does the true case (forward)
     */
	public CrossRoughTerrain() {
		this(true);
	}
}
