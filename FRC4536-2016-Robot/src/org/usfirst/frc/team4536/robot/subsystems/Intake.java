package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4536.robot.commands.DriveIntakeArm;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;

/**
 *@author Liam
 * Intake system for capturing and ejecting game balls
 */
public class Intake extends Subsystem {
	
	Talon intake;
	double oldThrottle;
	Relay relay;
	
	public Intake(int talonChannel) {
		
		intake = new Talon(talonChannel);

		relay = new Relay(RobotMap.INTAKE_RELAY, Relay.Direction.kForward);
		
		intake.set(0.0);
		
		oldThrottle = 0.0;
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveIntakeArm());
    }
    
    /**
     * @author Liam
     * @param throttle The signal value [-1, 1] sent to the intake motor.
     * Positive values eject the ball and negative values intake the ball so it's
     * intuitive for a joystick interface.
     */
    public void setThrottle(double throttle) {
    	
    	oldThrottle = throttle;
    	intake.set(-throttle);
    }
    /**
     * @author Sheila
     * 
     * @param throttle	The signal value [-1, 1] sent to the (intake arm?) motor,
     * after being edited to create an acceleration limit. Positive values eject 
     * the ball and negative values intake the ball so it's intuitive for a 
     * joystick interface.
     */
    public void setThrottleAccelLimited(double throttle) {
    	
    	throttle = Utilities.accelLimit(throttle, oldThrottle, Constants.ACCEL_LIMIT_INTAKE);
    	setThrottle(throttle);
    }

	/**
	 * @author Sheila
	 * 
	 * sets the relay to the 'on' position (releases the intake)
	 */
	public void relayOn() {
		
		relay.set(Relay.Value.kOn);
	}
	
	/**
	 * @author Sheila
	 * 
	 * sets the relay to the 'off' position (holds the intake up... or down?)
	 */
	public void relayOff() {
		
		relay.set(Relay.Value.kOff);
	}
	
	/**
	 * @author Sheila
	 * 
	 * checks whether the relay is off or on, and switches it
	 */
	public void relayFlip() {
		
		if (relay.get() == Relay.Value.kOff){
			
			relayOn();
		} 
		else {
			
			relayOff();
		}
	}
}

