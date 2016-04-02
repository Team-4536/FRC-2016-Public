package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossMoat extends CommandGroup {

	/**
	 * @author Audrey
	 * @param forward boolean if true, it goes forward if false, it goes backward
	 */
    public  CrossMoat(boolean forward) {
    	
    	addParallel(new ReleaseIntake());
    	
		DriveTrapezoidProfile crossMoat;
		
    	if (forward){
        	crossMoat = new DriveTrapezoidProfile(Constants.CROSS_MOAT_DISTANCE, Constants.CROSS_MOAT_VELOCITY, Constants.CROSS_MOAT_ACCEL_LIMIT, Constants.CROSS_MOAT_GYRO_PROPORTIONALITY);
        	double maxTime = crossMoat.getNeededTime() + Constants.CROSS_MOAT_EXTRA_TIME;
    		addSequential(crossMoat, maxTime);
    	}else{
        	crossMoat = new DriveTrapezoidProfile(-Constants.CROSS_MOAT_DISTANCE, Constants.CROSS_MOAT_VELOCITY, Constants.CROSS_MOAT_ACCEL_LIMIT, Constants.CROSS_MOAT_GYRO_PROPORTIONALITY);
        	double maxTime = crossMoat.getNeededTime() + Constants.CROSS_MOAT_EXTRA_TIME;
    		addSequential(crossMoat, maxTime);
    	}
    }
    
    /**
     * @author Liam
     * Does the true case (forward)
     */
    public CrossMoat() {
    	
    	this(true);
    }
}
