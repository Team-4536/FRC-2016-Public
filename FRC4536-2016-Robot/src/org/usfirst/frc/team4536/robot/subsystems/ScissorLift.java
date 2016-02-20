package org.usfirst.frc.team4536.robot.subsystems;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.commands.SafeDriveScissorLift;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author Liam
 *
 */
public class ScissorLift extends Subsystem {
	
	VictorSP scissorLift;
	double oldThrottle;
	Relay relay;
	
	public ScissorLift(int motorChannel){

		scissorLift = new VictorSP(motorChannel);
		oldThrottle = 0.0;
		relay = new Relay(RobotMap.SCISSOR_RELAY, Relay.Direction.kForward);
	}
		
	/**
	 * @author Liam
	 * @param Throttle the value [-1, 1] sent to the motor. Negative values make it climb.
	 * Positive values make it go down.
	 */
	public void driveLift(double throttle) {
		
		scissorLift.set(-throttle);
		oldThrottle = throttle;
    }
	
	public void safeDrive(double throttle) {
		double tempVar = throttle;
		throttle = Utilities.accelLimit(throttle, oldThrottle, Constants.ACCEL_LIMIT_DRIVE);
		throttle = Utilities.limit(throttle, -1.0, 0.0);
		driveLift(throttle);
		oldThrottle = tempVar;
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
			
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SafeDriveScissorLift());
    }
}