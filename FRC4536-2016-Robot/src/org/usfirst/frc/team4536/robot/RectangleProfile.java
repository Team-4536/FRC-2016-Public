package org.usfirst.frc.team4536.robot;

public class RectangleProfile {

	public double distance;
	public double timeNeeded;
	public double throttle;
	public double desiredMaxVelocity;
	
	/**
	 * @author Mairead
	 * @param distance The desired distance the robot should travel
	 * @param desiredMaxVelocity The speed the robot should be traveling at
	 */
	public RectangleProfile (double distance, double desiredMaxVelocity) {
		// distance is in feet
		// desiredMaxVelocity is in feet per second

		this.desiredMaxVelocity = desiredMaxVelocity;
		this.distance = distance;
		throttle = desiredMaxVelocity / Constants.DRIVE_TRAIN_MAX_VELOCITY; // Converts the desired velocity into a throttle value to send to the motors
		timeNeeded = distance / desiredMaxVelocity; // Uses physics to calculate the time needed

	}

	/**
	 * @author Mairead
	 * @param time The amount of time since the profile has started
	 * @returns The throttle the robot should be at
	 */
	public double throttle(double time) {
		// Returns the throttle value if the desired time has not passed

		if (time > 0 && time < timeNeeded) {
			return throttle;
		}

		else
			return 0;
	}
	
	/**
	 * @author Mairead
	 * @param time The amount of time since the profile has started
	 * @returns The veloctiy the robout should be at
	 */
	public double idealRate(double time) {
		if (time > 0 && time < timeNeeded) {
			return desiredMaxVelocity;
		} else
			return 0;
	}

	/**
	 * @author Mairead
	 * @param time The amount of time since the profile has started
	 * @returns The distance the robout should be at
	 */
	public double idealDistance(double time) {
		//For interfacing, returns the distance the robot SHOULD be at
		if (time > 0 && time < timeNeeded) {
			return desiredMaxVelocity * time;
		} else
			return distance;
	}

}
