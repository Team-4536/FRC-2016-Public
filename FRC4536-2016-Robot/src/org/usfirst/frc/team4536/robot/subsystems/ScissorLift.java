package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.Relay;
import org.usfirst.frc.team4536.robot.commands.SafeDriveScissorLift;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Noah
 * A system for lifting the robot
 */
public class ScissorLift extends Subsystem {
	
	VictorSP scissorLift;
	Relay relay;
	private double oldThrottle;
	
	public void initDefaultCommand() {
    	setDefaultCommand(new SafeDriveScissorLift());
    }
	
	public ScissorLift(int motorChannel){

		scissorLift = new VictorSP(motorChannel);
		oldThrottle = 0.0;
		relay = new Relay(RobotMap.SCISSOR_RELAY, Relay.Direction.kForward);
		
		oldThrottle = 0.0;
	}
		
	/**
	 * @author Noah
	 * @param Throttle the value [-1, 1] sent to the motor. Negative values make it climb.
	 * Positive values make it go down.
	 */
	private void driveLift(double throttle) {
		scissorLift.set(-throttle);
		oldThrottle = throttle;
    }
	
	public void safeDrive(double throttle) {
		double tempVar = throttle;
		throttle = Utilities.limit(throttle, -1.0, 0.0);
		throttle = Utilities.accelLimit(throttle, oldThrottle, Constants.ACCEL_LIMIT_DRIVE);
		driveLift(throttle);
		oldThrottle = tempVar;
	}
	
	/**
	 * @author Noah
	 */
	public void resetValues() {
		
		oldThrottle = 0.0;
	}
}