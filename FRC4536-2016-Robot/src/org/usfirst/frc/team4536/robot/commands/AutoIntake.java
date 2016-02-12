package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class AutoIntake extends CommandBase {
	
	Timer time = new Timer();
	boolean finished;
	double range;
	
	public AutoIntake() {
		requires(intake);
		requires(maxUltra);
	}
	
	public void initialize() {
		time.start();
	}
	
	public void execute() {
		range = maxUltra.getRange();
		if (time.get() < 5) {
			if (range > .75) {
				intake.setThrottle(.75);
				finished = false;
			}
			else if (range > .55 && range <= .75) {
				intake.setThrottle(.35);
			}
			else {
				intake.setThrottle(0);
				time.reset();
				finished = true;
			}
		}
		else {
			time.reset();
			finished = true;
		}
	}
	
	public boolean isFinished() {
		return finished;
	}
	
	public void end() {
		
	}
	
}
