package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Sheila
 * 
 * @param forward	are we crossing this defense forward(true) or backward(false)?
 */
public class StealBoulderAuto extends CommandGroup {
    
	public  StealBoulderAuto() {
		
			addParallel(new ReleaseIntake());
	    	
			DriveTrapezoidProfile backUp;
			
        	backUp = new DriveTrapezoidProfile(Constants.STEAL_BACKUP_DISTANCE, Constants.STEAL_BACKUP_VELOCITY, Constants.STEAL_BACKUP_ACCEL_LIMIT, Constants.STEAL_BACKUP_GYRO_PROPORTIONALITY);
        	double maxTime = backUp.getNeededTime() + 1;
    		addSequential(backUp, maxTime);
	    } //TODO back up (like 6 inches), turn, move to defense, turn, move to next auto
}
