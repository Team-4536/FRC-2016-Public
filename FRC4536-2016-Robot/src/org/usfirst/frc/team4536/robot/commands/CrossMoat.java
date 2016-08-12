package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;

public class CrossMoat extends CommandGroup {

	/**
	 * @author Audrey
	 * @param forward boolean if true, it goes forward if false, it goes backward
	 */
    public  CrossMoat(boolean forward) {
    	
    	addParallel(new ReleaseIntake());
    	
		DriveProfile crossMoat;
		
    	if (forward){
        	crossMoat = new DriveProfile(new TrapezoidProfile(Constants.CROSS_MOAT_DISTANCE, Constants.CROSS_MOAT_VELOCITY, Constants.CROSS_MOAT_ACCEL_LIMIT), CommandBase.driveTrain.getAngle(), -0.04);
        	double maxTime = crossMoat.getNeededTime() + Constants.CROSS_MOAT_EXTRA_TIME;
    		addSequential(crossMoat, maxTime);
    	}else{
        	crossMoat = new DriveProfile(new TrapezoidProfile(-Constants.CROSS_MOAT_DISTANCE, Constants.CROSS_MOAT_VELOCITY, Constants.CROSS_MOAT_ACCEL_LIMIT), CommandBase.driveTrain.getAngle(), -0.04);
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
