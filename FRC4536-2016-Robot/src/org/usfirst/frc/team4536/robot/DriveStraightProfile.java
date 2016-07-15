package org.usfirst.frc.team4536.robot;

public abstract class DriveStraightProfile extends Profile {

	protected double driveProportionality;
	protected double driveIntegral;
	protected double distanceThreshold;
	protected double velocityThreshold;
	
	/**
	 * @author Liam
	 * @return the encoder proportionality constant which converts from distance error (inches) to throttle
	 */
	public abstract double getDriveProportionality();
	
	/**
	 * @author Liam
	 * @return the encoder proportionality constant which converts from accumulated distance error (inches) to throttle
	 */
	public abstract double getDriveIntegral();
	
	/**
	 * @author Liam
	 * @return The distance the profile must travel to terminate the command
	 */
	public abstract double getDistance();
	
	/**
	 * @author Liam
	 * @return the distance threshold for the tolerance on command termination criteria
	 */
	public abstract double getDistanceThreshold();
	
	/**
	 * @author Liam
	 * @return the velocity threshold for the tolerance on command termination criteria
	 */
	public abstract double getVelocityThreshold();
}
