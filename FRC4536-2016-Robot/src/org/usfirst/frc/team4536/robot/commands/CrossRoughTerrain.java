package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Sheila
 *This command group crosses the rough terrain
 */
public class CrossRoughTerrain extends CommandGroup {
    
    public  CrossRoughTerrain(boolean forward) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	DriveTrapezoidProfile crossRoughTerrain;
    	
    	if (forward) {
    		crossRoughTerrain = new DriveTrapezoidProfile(Constants.CROSS_ROUGHTERRAIN_DISTANCE, Constants.CROSS_ROUGHTERRAIN_VELOCITY, Constants.CROSS_ROUGHTERRAIN_ACCEL_LIMIT);
    		double maxTime = crossRoughTerrain.getNeededTime() + 1;
    		addSequential(crossRoughTerrain, maxTime);
    	} else {
    		crossRoughTerrain = new DriveTrapezoidProfile(-Constants.CROSS_ROUGHTERRAIN_DISTANCE, Constants.CROSS_ROUGHTERRAIN_VELOCITY, Constants.CROSS_ROUGHTERRAIN_ACCEL_LIMIT);
    		double maxTime = crossRoughTerrain.getNeededTime() + 1;
    		addSequential(crossRoughTerrain, maxTime);
    	}
    }
    
	public CrossRoughTerrain() {
		this(true);
	}
}
