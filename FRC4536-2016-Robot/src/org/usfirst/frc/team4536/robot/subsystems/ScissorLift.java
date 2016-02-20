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
	 * @author Liam
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
	 * @author Sheila
	 * 
	 * safeDrive, but only activated after the match only has 20 seconds left
	 */
	public void superSafeDrive(double throttle) {
		//The full match time (150 seconds) - the time we have available to scale
		//this keeps us from violating the rules about extensions
		if(Utilities.getTime()>120-Constants.SCALE_TIME_LIMIT) {
			safeDrive(throttle);
		} else {
			System.out.println("Hey! The match is still going! No climbing yet!");
		}
		
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
	}
}