package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;


public class CrossRockWall extends CommandGroup {
	
	/**
 	* @author Audrey
 	* @param forward boolean if true, it goes forward if false, it goes backward
 	*/   
	public  CrossRockWall(boolean forward) {
		
		addParallel(new ReleaseIntake());
    	
		DriveTrapezoidProfile crossRockWall;
		
    	if (forward){
        	crossRockWall = new DriveTrapezoidProfile(Constants.CROSS_ROCKWALL_DISTANCE, Constants.CROSS_ROCKWALL_VELOCITY, Constants.CROSS_ROCKWALL_ACCEL_LIMIT);
        	double maxTime = crossRockWall.getNeededTime() + Constants.CROSS_ROCKWALL_EXTRA_TIME;
    		addSequential(crossRockWall, maxTime);
    	}else{
        	crossRockWall = new DriveTrapezoidProfile(-Constants.CROSS_ROCKWALL_DISTANCE, Constants.CROSS_ROCKWALL_VELOCITY, Constants.CROSS_ROCKWALL_ACCEL_LIMIT);
        	double maxTime = crossRockWall.getNeededTime() + Constants.CROSS_ROCKWALL_EXTRA_TIME;
    		addSequential(crossRockWall, maxTime);
    	}
	}
	
    /**
     * @author Liam
     * Does the true case (forward)
     */
	public CrossRockWall() {
		
		this(true);
	}
}
