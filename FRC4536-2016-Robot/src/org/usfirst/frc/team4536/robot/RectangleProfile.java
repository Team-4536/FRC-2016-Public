package org.usfirst.frc.team4536.robot;

public class RectangleProfile extends Profile {

	public double distance;
	public double timeNeeded;
	public double throttle;
	public double desiredMaxVelocity;
	
	/**
	 * @author Mairead
	 * @param distance The desired distance the robot should travel in feet
	 * @param desiredMaxVelocity The speed the robot should be traveling at in feet per second, always positive
	 */
	public RectangleProfile (double distance, double desiredMaxVelocity) {

		this.desiredMaxVelocity = desiredMaxVelocity;
		this.distance = distance;
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
	public double getThrottle(double time) {

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
	public double getIdealVelocity(double time) {
		
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
	public double getIdealDistance(double time) {
		
		if (time > 0 && time < timeNeeded && distance > 0) {
			return desiredMaxVelocity * time;
		} 
		else if (time > 0 && time < timeNeeded && distance < 0) {
			return desiredMaxVelocity * -time;
		} 
		else
			return distance;
	}

}
