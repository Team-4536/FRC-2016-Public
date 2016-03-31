package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

	CameraServer camServer;
	
	String camName = "cam0";
	
	protected void initDefaultCommand() {
	}
	
	public Camera() {
	}
	
	public void Start() {
		camServer = CameraServer.getInstance();
		camServer.setQuality(50);
		camServer.startAutomaticCapture(camName);
	}
	
}

