package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.Relay;
import org.usfirst.frc.team4536.robot.commands.SafeDriveScissorLift;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Liam
 * A system for lifting the robot
 */
public class ScissorLift extends Subsystem {
	
	VictorSP scissorLift;
	Relay relay;
	private double oldThrottle;
	private double currentThrottle;
	
	public void initDefaultCommand() {
    	setDefaultCommand(new SafeDriveScissorLift());
    }
	
	public ScissorLift(int motorChannel){

		scissorLift = new VictorSP(motorChannel);
		relay = new Relay(RobotMap.SCISSOR_RELAY, Relay.Direction.kForward);
		
		currentThrottle = 0.0;
		oldThrottle = 0.0;
	}
		
	/**
	 * @author Liam
	 * @param Throttle the value [-1, 1] sent to the motor. Negative values make it climb.
	 * Positive values make it go down.
	 */
	private void driveLift(double throttle) {
		
		scissorLift.set(-throttle);
    }
	
	/**
	 * @author Sheila
	 * 
	 * sets the relay to the 'on' position (releases the scissor lift)
	 */
	public void relayOn() {
		relay.set(Relay.Value.kOn);
	}
	
	/**
	 * @author Sheila
	 * 
	 * sets the relay to the 'off' position (holds the scissor lift folded)
	 */
	public void relayOff() {
		relay.set(Relay.Value.kOff);
	}

	/**
	 * @author Sheila
	 * 
	 * checks whether the relay is off, and sets it to whatever it's not
	 */
	public void relayFlip() {
		if (relay.get() == Relay.Value.kOff){
			relayOn();
		} else {
			relayOff();
		}
	}
	
	/**
	 * @author Liam
	 */
	public void resetValues() {
		
		oldThrottle = 0.0;
		currentThrottle = 0.0;
	}
	
	/**
	 * @author Noah
	 * @param throttle Speed to set the motor ro
	 * Drives the motor safely
	 */
	public void safeDrive(double throttle) {
		
		currentThrottle = Utilities.limit(throttle, -1.0, 0.0);
		
		driveLift(Utilities.accelLimit(currentThrottle, oldThrottle, Constants.SCISSOR_SAFE_FULL_SPEED_TIME));
		
		oldThrottle = currentThrottle;
	}
}