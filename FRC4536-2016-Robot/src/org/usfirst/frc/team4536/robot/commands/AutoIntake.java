package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class AutoIntake extends CommandBase {
	
	Timer time = new Timer();
	boolean finished;
	
	public AutoIntake() {
		requires(intake);
		requires(maxUltra);
	}
	
	public void initialize() {
		time.reset();
		time.start();
		finished = false;
	}
	
	public void execute() {
		if (time.get() < 5) {
			if (maxUltra.getRange() > .25) {
				intake.setThrottle(1);
				finished = false;
			}
			else {
				intake.setThrottle(0);
				finished = true;
			}
		}
		else {
			finished = true;
		}
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public void end() {
		
	}
	
}
