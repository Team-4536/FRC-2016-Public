package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;

public class CrossRockWall extends CommandGroup {
	
	/**
 	* @author Audrey
 	* @param forward boolean if true, it goes forward if false, it goes backward
 	*/   
	public  CrossRockWall(boolean forward) {
		
		addParallel(new ReleaseIntake());
    	
		DriveProfile crossRockWall;
		
    	if (forward){
        	crossRockWall = new DriveProfile(new TrapezoidProfile(Constants.CROSS_ROCKWALL_DISTANCE, Constants.CROSS_ROCKWALL_VELOCITY, Constants.CROSS_ROCKWALL_ACCEL_LIMIT));
        	double maxTime = crossRockWall.getNeededTime() + Constants.CROSS_ROCKWALL_EXTRA_TIME;
    		addSequential(crossRockWall, maxTime);
    	}else{
        	crossRockWall = new DriveProfile(new TrapezoidProfile(-Constants.CROSS_ROCKWALL_DISTANCE, Constants.CROSS_ROCKWALL_VELOCITY, Constants.CROSS_ROCKWALL_ACCEL_LIMIT));
        	double maxTime = crossRockWall.getNeededTime() + Constants.CROSS_ROCKWALL_EXTRA_TIME;
    		addSequential(crossRockWall, maxTime);
    	}
	}
	
    /**
     * @author Noah
     * Does the true case (forward)
     */
	public CrossRockWall() {
		
		this(true);
	}
}
