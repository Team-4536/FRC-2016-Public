package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * intakes ball from midline, turns & backs out, and turns back to (to be determined) defense.
 * @author Sheila
 */
public class StealBoulderAuto extends CommandGroup {
    
	public StealBoulderAuto() {
		this(0); //TODO choose default position
	}
	
	public  StealBoulderAuto(int position) {
		
		double positionDistance = position*Constants.DEFENSE_LENGTH;
		
		addSequential(new AutoIntake());
		addSequential(new DriveTrapezoidProfile(Constants.STEAL_BOULDER_FIRST_LEG_DISTANCE));
		addSequential(new TurnTrapezoidProfile(Constants.STEAL_BOULDER_FIRST_LEG_ANGLE));
		addSequential(new DriveTrapezoidProfile(Constants.STEAL_BOULDER_SECOND_LEG_DISTANCE 
															- positionDistance));
		addSequential(new TurnTrapezoidProfile(Constants.STEAL_BOULDER_SECOND_LEG_ANGLE));
    } 
}
