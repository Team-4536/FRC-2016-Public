package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

public class AutoIntake extends CommandBase {
	
	boolean finished;
	double error;
	
	public AutoIntake() {
		requires(intake);
	}
	
	public void initialize() {
		setTimeout(5);
	}
	
	public void execute() {
		error = intake.getdistance() - Constants.INTAKE_DESIRED_DISTANCE;
		intake.setThrottleAccelLimited(error * Constants.P_CONSTANT);
	}
	
	public boolean isFinished() {
		return isTimedOut();
	}
	
	public void end() {
		
	}
	
}
