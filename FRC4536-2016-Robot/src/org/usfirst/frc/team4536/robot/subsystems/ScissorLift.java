package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Liam
 * A system for lifting the robot
 */
public class ScissorLift extends Subsystem {
	
	VictorSP scissorLift;
	Relay relay;
	
	public void initDefaultCommand() {
    }
	
	public ScissorLift(int motorChannel){

		scissorLift = new VictorSP(motorChannel);
		relay = new Relay(RobotMap.SCISSOR_RELAY, Relay.Direction.kForward);
		
	}
		
	/**
	 * @author Liam
	 * @param Throttle the value [-1, 1] sent to the motor. Negative values make it climb.
	 * Positive values make it go down.
	 */
	public void driveLift(double throttle) {
		
		scissorLift.set(-throttle);
    }
	
	/**
	 * @author Sheila
	 * Activates the relay
	 */
	public void relayOn() {
		relay.set(Relay.Value.kOn);
	}
	
	/**
	 * @author Noah
	 * Deactivates the relay
	 */
	public void relayOff() {
		relay.set(Relay.Value.kOff);
	}
	
	/**
	 * @author Noah
	 * Flips the relay
	 */
	public void relayFlip() {
		if (relay.get() == Relay.Value.kOn){
			relayOn();
		} else {
			relayOff();
		}
	}
	
	/**
	 * @author Noah
	 * @param throttle Speed to set the motor ro
	 * Drives the motor safely
	 */
	public void safeDrive(double throttle) {
		driveLift(Utilities.limit(throttle, -1.0, 0.0));
	}
			
}