package org.usfirst.frc.team4536.robot;

//TODO add protected members for proportionality and integral constants
public abstract class Profile {
	
	protected double turnProportionality;
	protected double turnIntegral;
	protected double timeoutOffset;
	protected double angleThreshold;
	protected double angularVelocityThreshold;
	
	/**
	 * @author Liam
	 * @return the proportionality constant to convert from error (degrees) to throttle
	 */
	public abstract double getTurnProportionality();
	
	/**
	 * @author Liam
	 * @return the proportionality constant for the integral term to convert from accumulated error (degrees * time) to throttle
	 */
	public abstract double getTurnIntegral();
	
	/**
	 * @author Liam
	 * @return the timeout offset of the profile
	 */
	public abstract double getTimeoutOffset();
	
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
	
	/**
	 * @author Liam
	 * @return the angle threshold of the profile for command termination
	 */
	public abstract double getAngleThreshold();
	
	/**
	 * @author Liam
	 * @return the angular velocity threshold of the profile for command termination
	 */
	public abstract double getAngularVelocityThreshold();
}
