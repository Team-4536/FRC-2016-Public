package org.usfirst.frc.team4536.robot;

public class RectangleProfileForTurning {

	public double angle;
	public double timeNeeded;
	public double stictionAdjustment;
	public double throttle;
	public double desiredMaxAngularVelocity;
	
	/**
	 * @author Mairead
	 * @param angle The angle the robot should turn
	 * (ex: if the robot's at 20 degrees and angle = 50, it will turn to 70 degrees)
	 * @param desiredMaxAngularVelocity The speed the robot should be turning at in degrees per second, always positive
	 */
	public RectangleProfileForTurning (double angle, double desiredMaxAngularVelocity) {

		this.desiredMaxAngularVelocity = desiredMaxAngularVelocity;
		this.angle = angle;
		stictionAdjustment = Utilities.adjustForStiction(desiredMaxAngularVelocity, Constants.ZENITH_TURN_STICTION, Constants.ZENITH_DRIVE_TRAIN_MAX_ANGULAR_VELOCITY);
		if(angle > 0){
			throttle = stictionAdjustment;
		} // Converts the desired velocity into a throttle value to send to the motors
		if(angle < 0){
			throttle = -stictionAdjustment;
		}
		timeNeeded = Math.abs(angle / desiredMaxAngularVelocity); // Uses physics to calculate the time needed

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
	public double idealRate(double time) {
		
		if (time > 0 && time < timeNeeded) {
			return desiredMaxAngularVelocity;
		} else
			return 0;
	}

	/**
	 * @author Mairead
	 * @param time The amount of time since the profile has started
	 * @returns The angle the robot should be at
	 */
	public double idealAngle(double time) {
		
		if (time > 0 && time < timeNeeded && angle > 0) {
			return desiredMaxAngularVelocity * time;
		} 
		if (time > 0 && time < timeNeeded && angle < 0) {
			return desiredMaxAngularVelocity * -time;
		} 
		else
			return angle;
	}

}
