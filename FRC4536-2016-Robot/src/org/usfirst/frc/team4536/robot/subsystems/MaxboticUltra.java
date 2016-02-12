package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

public class MaxboticUltra extends Subsystem {
	
	AnalogInput ultra;
	double range;
	
	public void initDefaultCommand() {
		
	}
	
	public MaxboticUltra(int channel) {
		ultra = new AnalogInput(channel);
	}
	
	public double getRange() {
		range = ultra.getValue() / Constants.MAX_ULTRA_CONVERSION;
		System.out.println(range);
		return range;
	}
	
}
