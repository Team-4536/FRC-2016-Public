package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.Timer;

/**
 * @author Noah
 * Command to automatically intake the ball using an ultrasonic sensor
 */
public class AutoIntake extends CommandBase {
	
	Timer time = new Timer();
	boolean finished;
	double range;
	
	public AutoIntake() {
		requires(intake);
	}
	
	public void initialize() {
		time.start();
	}
	
	public void execute() {
		range = intake.getdistance();
		if (time.get() < Constants.AUTO_INTAKE_TIMEOUT) {
			if (range > Constants.AUTO_INTAKE_FAR_DIST) {
				intake.setThrottle(Constants.AUTO_INTAKE_FAST_SPEED);
				finished = false;
			}
			else if (range > Constants.AUTO_INTAKE_CLOSE_DIST && range <= Constants.AUTO_INTAKE_FAR_DIST) {
				intake.setThrottle(Constants.AUTO_INTAKE_SLOW_SPEED);
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
