package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 *Approaches and stops when colliding with even a ball, then tries to pick it up automatically.
 */
public class AutoApproachPickupBoulder extends CommandGroup {
    
	/**
	 * @author Liam
	 */
    public  AutoApproachPickupBoulder() {
    	
    	addParallel(new IntakeCurrent());
    	addSequential(new DriveTrapezoidProfile(Constants.AUTO_APPROACH_DEFAULT_DISTANCE,
    										Constants.AUTO_APPROACH_SPEED, Constants.AUTO_APPROACH_ACCELERATION));
    }
    
    /**
     * @author Liam
     * @param distance the distance the robot should roam for to collide with boulders and try to pick them up.
     */
    public AutoApproachPickupBoulder(double distance) {

    	
    	addParallel(new IntakeCurrent());
    	addSequential(new DriveTrapezoidProfile(distance,
    										Constants.AUTO_APPROACH_SPEED, Constants.AUTO_APPROACH_ACCELERATION));
    }
}
