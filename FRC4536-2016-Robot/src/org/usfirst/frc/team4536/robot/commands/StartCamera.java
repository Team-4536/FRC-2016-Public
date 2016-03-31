package org.usfirst.frc.team4536.robot.commands;

public class StartCamera extends CommandBase {
	
	public StartCamera() {
		requires(camera);
	}
	
	public void initialize() {
		camera.Start();
	}
	
	public void execute() {
		
	}
	
	public void interrupted() {
		end();
	}
	
	public void end() {
	}
	
}
