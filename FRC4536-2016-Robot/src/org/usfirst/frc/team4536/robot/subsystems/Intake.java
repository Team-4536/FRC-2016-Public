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
    
    public void setThrottle(double throttle) {
    	
    	intake.set(throttle);
    }
}

