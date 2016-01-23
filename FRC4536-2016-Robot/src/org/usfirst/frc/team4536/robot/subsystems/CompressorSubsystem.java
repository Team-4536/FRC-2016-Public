package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;

public class CompressorSubsystem extends Subsystem{
	
	Compressor compressor;
	
	/**
	 * @author Sheila
	 */
	public CompressorSubsystem() {
		compressor = new Compressor();
	}
	
	/**
	 * @author Sheila
	 */
	public void initDefaultCommand() {
		
	}
	
	/**
	 * @author Sheila
	 * Start the compressor running in closed loop control mode
	 */
	public void startComp() {
		compressor.start();
	}
	
	/**
	 * @ author Sheila
	 * Stops the compressor running in closed loop control mode
	 */
	public void stopComp() {
		compressor.stop();
	}
}
