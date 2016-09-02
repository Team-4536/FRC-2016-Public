package org.usfirst.frc.team4536.robot;

public class TrapezoidIntegralProfile extends Profile {
	
	private double distance; //The distance the profile should travel, in feet. Negative distances move backwards, positive distances move forwards. 
	private double maxSpeed; //The maximum speed the profile should reach, in feet/second. 
	private double maxAccel; //The maximum acceleration the speed can change, in feet/second^2. 
	
	private double timeNeeded; //The time needed to execute the profile, in seconds. 
	private double integral; //the distance ideally traveled so far
	
	private boolean triangle; //Whether the profile graphs as a triangle (always accelerating) or trapezoid (stays at max speed for a bit)
	
	public TrapezoidIntegralProfile(double distanceToTravel, double maxSpeed, double maxAcceleration) {
		this.distance = distanceToTravel; 
		this.maxSpeed = maxSpeed;
		this.maxAccel = maxAcceleration;
		integral = 0.0;
		
		//TODO timeNeeded = ?
		
	}
	
	/**
	 * returns the throttle the robot should be at and updates variables
	 * 
	 * @param time the amount of time since the profile was started
	 * @return the throttle the robot should be at
	 */
	public double throttle(double time) {
		//TODO integral += ?;
		return Utilities.adjustForStiction(idealVelocity(time), Constants.FORWARD_STICTION, Constants.DRIVE_TRAIN_MAX_VELOCITY);
	}
	
	/**
	 * @param time the amount of time since the profile was started
	 * @return the ideal velocity of the robot at this stage
	 */
	public double idealVelocity(double time) {
		//TODO auto-generated method stub
		return 0;
	}
	
	public double idealDistance(double time) {
		//TODO auto-generated method stub
		return 0;
	}
	
	public double getTimeNeeded() {
		return timeNeeded;
	}
	
	public double getDistance() {
		return distance;
	}
	
}
