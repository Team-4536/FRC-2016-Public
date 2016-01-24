package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Piston extends Subsystem{
	
	Timer extendedTimer;
	Timer retractedTimer;
	Solenoid leftSolenoid; //extendChannel and retractChannel might be better names for these, since left and right don't really matter
	Solenoid rightSolenoid;
	
	/**
	 * @author Sheila
	 * @param leftSolenoidChannel channel that the left solenoid is plugged into on the roboRIO
	 * @param rightSolenoidChannel channel that the right solenoid is plugged into on the roboRIO
	 */
	public Piston(int leftSolenoidChannel, int rightSolenoidChannel) {
		leftSolenoid = new Solenoid(leftSolenoidChannel);
		rightSolenoid = new Solenoid(rightSolenoidChannel);
		
		extendedTimer = new Timer();
		retractedTimer = new Timer();
		
		if(isExtended()) {
			extendedTimer.start();
		}
		if(isRetracted()) {
			retractedTimer.start();
		}
	}
	
	public void initDefaultCommand() {
	    // Set the default command for a subsystem here.
	    //setDefaultCommand(new MySpecialCommand());	    	
	}
	
	/**
	 * @author Sheila
	 * 
	 * flips the piston from extended to retracted, and switches matching timers
	 */
	public void retract() {
		leftSolenoid.set(true);
		extendedTimer.stop();
		extendedTimer.reset();
		
		rightSolenoid.set(false);
		retractedTimer.start();
	}
	
	/**
	 * @author Sheila
	 * 
	 * flips the piston from retracted to extended, and switches matching timers
	 */
	public void extend() {
		leftSolenoid.set(false);
		retractedTimer.stop();
		retractedTimer.reset();
		
		rightSolenoid.set(true);
		extendedTimer.start();
	}
	
	/**
	 * @author Sheila
	 * Sets the state of piston to the opposite of its current state and switches timers
	 */
	public void flip() {
		//This method is way more complicated than it needs to be, use extend() and retract() to simplify
		leftSolenoid.set(!leftSolenoid.get());
		rightSolenoid.set(!rightSolenoid.get());
		
		if (retractedTimer.get() > 0) {
			retractedTimer.stop();
			retractedTimer.reset();
		} else {
			retractedTimer.start();
		}
		
		if (extendedTimer.get() > 0) {
			extendedTimer.stop();
			extendedTimer.reset();
		} else {
			extendedTimer.start();
		}
	}
	
	/**
	 * @author Sheila
	 */
	public boolean isExtended() {
		return rightSolenoid.get();
	}
	
	/**
	 * @author Sheila
	 */
	public boolean isRetracted() {
		return leftSolenoid.get();
	}
	
	/**
	 * @author Sheila
	 * @return amount of time that the piston has been extended (in milliseconds)
	 */
	public double timeExtended() {
		return extendedTimer.get();
	}
	
	/**
	 * @author Sheila
	 * @return amount of time that the piston has been retracted (in milliseconds)
	 */
	public double timeRetracted() {
		return retractedTimer.get();
	}
}
