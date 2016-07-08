package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto2LowGoal extends CommandGroup {
    
    public  Auto2LowGoal() {
    	
    	CommandBase.driveTrain.resetNavX(Constants.SPY_BOT_ANGLE);
    	addParallel(new ReleaseIntake());
    	addSequential(new TeleopTurn(90));
    	addSequential(new EjectBoulderAccelLimited());
    	addSequential(new TeleopTurn(180));
    	addSequential(new DriveTrapezoidProfile(14));
    	addSequential(new AutoApproachPickupBoulderStop(4, 180));
    	addSequential(new TeleopTurn(0));
    	addSequential(new LowBarLowGoal());
    }
}
