package org.usfirst.frc.team4536.robot;

public class RectangleProfile extends DriveStraightProfile {

	private double distance;
	private double timeNeeded;
	private double throttle;
	private double desiredMaxVelocity;
	
	/**
	 * @author Mairead
	 * @param distance The desired distance the robot should travel in feet
	 * @param desiredMaxVelocity The speed the robot should be traveling at in feet per second, always positive
	 */
	public RectangleProfile (double distance, double desiredMaxVelocity) {

		this.desiredMaxVelocity = desiredMaxVelocity;
		this.distance = distance;
		
		driveProportionality = Constants.RECTANGLE_FORWARD_PROPORTIONALITY;
		turnProportionality = Constants.RECTANGLE_TURN_PROPORTIONALITY;
		driveIntegral = Constants.TRAPEZOID_INTEGRAL;
		turnIntegral = Constants.TURNING_TRAPEZOID_INTEGRAL;
		timeoutOffset = Constants.TRAPEZOID_PROFILE_TIMEOUT_OFFSET;
		distanceThreshold = Constants.RECTANGLE_DISTANCE_THRESHOLD;
		velocityThreshold = Constants.RECTANGLE_VELOCITY_THRESHOLD;
		angleThreshold = Constants.RECTANGLE_ANGLE_THRESHOLD;
		angularVelocityThreshold = Constants.RECTANGLE_ANGULAR_SPEED_THRESHOLD;
		
		if(distance > 0){
			throttle = desiredMaxVelocity / Constants.DRIVE_TRAIN_MAX_VELOCITY;
		} // Converts the desired velocity into a throttle value to send to the motors
		if(distance < 0){
			throttle = -desiredMaxVelocity / Constants.DRIVE_TRAIN_MAX_VELOCITY;
		}
		timeNeeded = Math.abs(distance / desiredMaxVelocity); // Uses physics to calculate the time needed

	}

	/**
	 * @author Mairead
	 * @param time The amount of time since the profile has started
	 * @returns The throttle the robot should be at
	 */
	public double throttle(double time) {

		if (time > 0 && time < timeNeeded) {
			return throttle;
		}

		else
			return 0;
	}
	
	/**
	 * @author Mairead
	 * @param time The amount of time since the profile has started
	 * @returns The veloctiy the robot should be at
	 */
	public double idealVelocity(double time) {
		
		if (time > 0 && time < timeNeeded) {
			return desiredMaxVelocity;
		} else
			return 0;
	}

	/**
	 * @author Mairead
	 * @param time The amount of time since the profile has started
	 * @returns The distance the robot should be at
	 */
	public double idealDistance(double time) {
		
		if (time > 0 && time < timeNeeded && distance > 0) {
			return desiredMaxVelocity * time;
		} 
		else if (time > 0 && time < timeNeeded && distance < 0) {
			return desiredMaxVelocity * -time;
		} 
		else
			return distance;
	}
	
	/**
	 * @author Liam
	 * @return timeNeeded the theoretical time needed for the profile to execute without correction
	 */
	public double getTimeNeeded() {
		
		return this.timeNeeded;
	}
	
	/**
	 * @author Liam
	 * @return the distance the profile will travel
	 */
	public double getDistance() {
		
		return distance;
	}
	
	/**
	 * @author Liam
	 * @return timeoutOffset. The time added to the timeNeeded to set the timeout.
	 */
	public double getTimeoutOffset() {
		
		return timeoutOffset;
	}
	
	/**
	 * @author Liam
	 * @return the turn proportionality constant for the integral which converts accumulated angle error (degrees) to throttle
	 */
	public double getTurnIntegral() {
		
		return turnIntegral;
	}
	
	/**
	 * @author Liam
	 * @return the turn proportionality constant which converts angle error (degrees) to throttle
	 */
	public double getTurnProportionality() {
		
		return turnProportionality;
	}
	
	/**
	 * @author Liam
	 * @return the drive proportionality constant for the integral which converts accumulated distance error (inches) to throttle
	 */
	public double getDriveIntegral() {
		
		return driveIntegral;
	}
	
	/**
	 * @author Liam
	 * @return the drive proportionality constant which converts distance error (inches) to throttle
	 */
	public double getDriveProportionality() {
		
		return driveProportionality;
	}
	
	/**
	 * @author Liam
	 * @return the distance threshold for the tolerance on command termination criteria
	 */
	public double getDistanceThreshold() {
		
		return distanceThreshold;
	}
	
	/**
	 * @author Liam
	 * @return the velocity threshold for the tolerance on command termination criteria
	 */
	public double getVelocityThreshold() {
		
		return velocityThreshold;
	}
	
	/**
	 * @author Liam
	 * @return the angle threshold of the profile for command termination
	 */
	public double getAngleThreshold() {
		
		return angleThreshold;
	}
	
	/**
	 * @author Liam
	 * @return the angular velocity threshold of the profile for command termination
	 */
	public double getAngularVelocityThreshold() {
		
		return angularVelocityThreshold;
	}
}
