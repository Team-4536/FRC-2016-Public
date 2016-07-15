package org.usfirst.frc.team4536.robot;

public abstract class Profile {

	/**
	 * @author Mairead and Liam
	 * @param time The amount of time since the profile has started
	 * @returns The throttle the robot should be at
	 */
	public abstract double throttle(double time);
	
	/**
	 * @author Mairead and Liam
	 * @param time The amount of time since the profile has started
	 * @returns The veloctiy the robot should be at
	 */
	public abstract double idealVelocity(double time);

	/**
	 * @author Mairead and Liam
	 * @param time The amount of time since the profile has started
	 * @returns The distance the robot should be at
	 */
	public abstract double idealDistance(double time);
	
	/**
	 * @author Liam
	 * @return timeNeeded the theoretical time needed for the profile to execute without correction
	 */
	public abstract double getTimeNeeded();
}
