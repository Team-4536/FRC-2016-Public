package org.usfirst.frc.team4536.robot;

import java.lang.Math;

/**
 * 
 * @author Liam
 *
 */
public class TurningTrapezoidProfile extends Profile{
	
	//TODO label direction
	private double angle; // angle The angle the profile should travel in degrees. Negative angles turn left, positive right.
	private double timeNeeded; // The time needed to execute the profile In seconds
	private double desiredMaxAngularSpeed; // The maximum angular speed the profile may achieve in degrees per second. Angular speed is a scalar so it's always positive because we don't care about direction.
	private double desiredMaxAngularAcceleration; // The maximum angular acceleration the angular speed can change by in degrees per second squared. We treat acceleration as the raw change in speed and thus as a scalar so it is always positive.
	private double criticalAngle; // This determines whether the profile is a triangle or a trapezoid.
	private double criticalTime; // This is the time it takes to reach maxSpeed if it is reached
	private boolean triangle; // Whether the profile develops a triangle or trapezoid profile
	
	/**
	 * @author Liam
	 * @param angle The angle the profile should travel in degrees. Negative angles turn left, positive right.
	 * @param maxAngularSpeed The maximum speed the profile may achieve in degrees per second. Angular speed is a scalar so it's always positive.
	 * @param maxAngularAcceleration The maximum angular acceleration the angular speed can change by in degrees per second squared. We treat acceleration as the raw change in angular speed and thus as a scalar so it is always positive.
	 */
	public TurningTrapezoidProfile (double angle, double maxAngularSpeed, double maxAngularAcceleration) {
		
		this.angle = angle;
		this.desiredMaxAngularSpeed = maxAngularSpeed;
		this.desiredMaxAngularAcceleration = maxAngularAcceleration;
		
		criticalTime = this.desiredMaxAngularSpeed/this.desiredMaxAngularAcceleration;
		criticalAngle = criticalTime * this.desiredMaxAngularSpeed/2;
		
 		if (Math.abs(this.angle) > criticalAngle) {
			
			triangle = false;
		}
		else {
			
			triangle = true;
		}
		
		if (triangle) {
			
			this.timeNeeded = 2*Math.sqrt(Math.abs(this.angle/this.desiredMaxAngularAcceleration));
		}
		else {
			
			this.timeNeeded = (2*criticalTime) + ((Math.abs(this.angle) - 2*criticalAngle)/this.desiredMaxAngularSpeed);
		}
	}
		
		/**
		 * @author Liam
		 * @param The amount of time since the profile has started
		 * @returns The throttle the robot should be at
		 */
		public double throttle(double time) {

			return Utilities.adjustForStiction(idealVelocity(time), Constants.ZENITH_TURN_STICTION, Constants.ZENITH_DRIVE_TRAIN_MAX_ANGULAR_VELOCITY);
		}
		
		/**
		 * @author Liam
		 * @return timeNeeded the theoretical time need for the profile to execute without correction
		 */
		public double timeNeeded() {
			
			return this.timeNeeded;
		}
		
		/**
		 * @author Liam
		 * @param time The amount of time since the profile has started
		 * @returns The angular velocity the robot should be at
		 */
		public double idealVelocity(double time) {
			
			double velocity;
			
			if (triangle) {
				
				if(time <= timeNeeded/2 && time > 0) { // first leg of triangle
					
					velocity =  this.desiredMaxAngularAcceleration*time;
				}
				else if (time > timeNeeded/2 && time <= timeNeeded){ // second leg of triangle
					
					double maxTriangleVelocity = this.desiredMaxAngularAcceleration*timeNeeded/2;
					
					velocity = -this.desiredMaxAngularAcceleration*(time - timeNeeded/2) + maxTriangleVelocity;
				}
				else { // garbage
					
					velocity = 0.0;
				}
			}
			else {//trapezoid
				
				if(time <= criticalTime && time >= 0) {//0 to max velocity
					
					velocity = this.desiredMaxAngularAcceleration*time;
				}
				else if (time > criticalTime && time < (timeNeeded - criticalTime)) {//max velocity
					
					velocity = this.desiredMaxAngularSpeed;
				}
				else if (time >= (timeNeeded - criticalTime) && time <= timeNeeded) {//max velocity to 0
					
					velocity = this.desiredMaxAngularAcceleration*(timeNeeded - time);
				}
				else {//Garbage
					
					velocity = 0;
				}
			}
			
			if (angle < 0) {
				
				return -velocity;
			}
			else {
				
				return velocity;
			}
		}
		
		/**
		 * @author Liam
		 * @return angle the robot should be at by that time
		 */
		public double idealDistance(double time) {
			
			double angle;
			
			if (triangle) {
				
				if (time >= 0 && time <= timeNeeded/2) { // First Half, before timeNeeded divided by 2
					
					angle = idealVelocity(time) * time / 2;
				}
				else if (time > timeNeeded/2 && time <= timeNeeded) { // Second Half, after timeNeeded divided by 2
						
					angle = this.angle - (idealVelocity(timeNeeded-time)* (timeNeeded-time))/2;
				}
				else if (time > timeNeeded) { // TimeNeeded or greater
					
					angle = this.angle;
				}
				else { // Negative Time
					
					angle = 0;
				}
			}
			else { // Trapezoid
				
				if (time >= 0 && time <= criticalTime) { // The first leg of the trapezoid
					
					angle = idealVelocity(time)*time/2;
				}
				else if (time > criticalTime && time <= (timeNeeded - criticalTime)) { // The body of the trapezoid
					
					if (this.angle > 0) {
						
						angle = this.desiredMaxAngularSpeed * (time - criticalTime) + criticalAngle;
					}
					else {
						
						angle = -this.desiredMaxAngularSpeed * (time - criticalTime) - criticalAngle;
					}
				}
				else if (time > (timeNeeded - criticalTime) && time <= timeNeeded) { // The last leg of the trapezoid
					
					angle = this.angle - (idealVelocity(timeNeeded - time) * (timeNeeded - time))/2;
				}
				else if (time > timeNeeded) { // After timeNeeded when the angle should have been covered
					
					angle = this.angle;
				}
				else { // Garbage negative values
					
					angle = 0;
				}
			}
			
			if (this.angle < 0) {
				
				if (angle < 0) {
					
					return angle;
				}
				
				return -angle;
			}
			else {
				
				if (angle < 0) {
					
					return -angle;
				}
				
				return angle;
			}
		}
		
		/**
		 * @author Liam
		 * @return triangle whether the profile has developed a triangle or trapezoid profile
		 */
		public boolean isTriangle() {
			
			return triangle;
		}
		
		/**
		 * @author Liam
		 * @return the angle the profile will travel to
		 */
		public double getAngle() { //TODO change to getAngle
			
			return angle;
		}
}
