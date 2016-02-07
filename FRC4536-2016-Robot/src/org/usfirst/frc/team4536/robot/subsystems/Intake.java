package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.Talon;

/**
 *@author Liam
 * Intake system for capturing and ejecting game balls
 */
public class Intake extends Subsystem {
	
	Talon intake;
	
	public Intake(int talonChannel) {
		
		intake = new Talon(talonChannel);
		
		intake.set(0.0);
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * @author Liam
     * @param throttle The signal value [-1, 1] sent to the scissor lift motor.
     * Positive values eject the ball and negative values intake the ball so it's
     * intuitive for a joystick interface.
     */
    public void setThrottle(double throttle) {
    	
    	intake.set(-throttle);
    }
}

