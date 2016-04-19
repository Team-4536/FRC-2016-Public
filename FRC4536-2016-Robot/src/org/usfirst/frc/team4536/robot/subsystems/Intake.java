package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team4536.robot.commands.DriveIntakeAccelLimited;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *@author Liam
 * Intake system for capturing and ejecting game balls
 */
public class Intake extends Subsystem {
	
	Talon intake;
	double oldThrottle;
	
	Relay relay;
	
	AnalogInput irSensor;
	double irDist;
	
	public Intake(int talonChannel, int relayChannel, int irChannel) {
		
		intake = new Talon(talonChannel);
		
		relay = new Relay(relayChannel, Relay.Direction.kForward);
		
		irSensor = new AnalogInput(irChannel);
		
		intake.set(0.0);
		
		oldThrottle = 0.0;
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveIntakeAccelLimited());
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
     * @author Audrey
     * 
     * @param throttle	The signal value [-1, 1] sent to the (intake arm?) motor,
     * after being edited to create an acceleration limit. Positive values eject 
     * the ball and negative values intake the ball so it's intuitive for a 
     * joystick interface.
     *
     * @param accel limit Can be set to accel limit other than default
     */
    public void setThrottleAccelLimited(double throttle, double accel) {
    	
    	throttle = Utilities.accelLimit(throttle, oldThrottle, accel);
    	setThrottle(throttle);
    }

	
	/**
	 * @author Liam
	 * 
	 */
	public void resetAccelValues() {
		
		oldThrottle = 0.0;
	}
	
	/**
	 * @author Noah
	 * @return IR distance in inches
	 */
	public double getdistance() {
		irDist = 21 - (10 * (irSensor.getVoltage()));
		return irDist;
	}
	
}

