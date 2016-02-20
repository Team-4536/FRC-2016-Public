package org.usfirst.frc.team4536.robot;
import java.lang.Math;

/**
 * 
 * @author Liam
 *
 */
public class TurningTrapezoidProfile extends Profile {

	private double angle;
	private double timeNeeded;
	private double desiredMaxAngularSpeed;
	private double desiredMaxAngularAcceleration;
	private double criticalAngle; //This determines whether the profile is a triangle or a trapezoid.
	private double criticalTime; //This is the time it takes to reach maxAngularSpeed
	private boolean triangle;
	
	/**
	 * @author Liam
	 * @param The angle the profile should travel in feet. Negative distances move backwards, positive forwards.
	 * @param The maximum angular speed the profile may achieve in feet per second. Angular speed is a scalar so it's always positive.
	 * @param The maximum angular acceleration the speed can change by in feet per second squared. We treat angular acceleration as the raw change in speed and thus as a scalar so it is always positive.
	 */
	public TurningTrapezoidProfile (double angle, double maxAngularSpeed, double maxAcceleration) {
		
		this.angle = angle;
		this.desiredMaxAngularSpeed = Math.abs(maxAngularSpeed);
		this.desiredMaxAngularAcceleration = Math.abs(maxAcceleration);
		
		criticalTime = this.desiredMaxAngularSpeed/this.desiredMaxAngularAcceleration;
		criticalAngle = criticalTime * this.desiredMaxAngularSpeed/2;
		
 		if (this.angle > criticalAngle) {
			
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
	 * @param time The amount of time since the profile has started
	 * @returns The throttle the robot should be at
	 */
	public double throttle(double time) {
		
		//return idealVelocity(time)/Constants.ZENITH_DRIVE_TRAIN_MAX_ANGULAR_VELOCITY;
		return Utilities.adjustForStiction(idealVelocity(time), Constants.ZENITH_TURN_STICTION, Constants.ZENITH_DRIVE_TRAIN_MAX_ANGULAR_VELOCITY);
	}
	
	/**
	 * @author Liam
	 * @param time The amount of time since the profile has started
	 * @returns The angular speed the robot should be at
	 */
	public double idealVelocity(double time) {
		
		double angularSpeed;
		
		if (triangle) {
			
			if(time <= timeNeeded/2 && time > 0) { // first leg of triangle
				
				angularSpeed =  this.desiredMaxAngularAcceleration*time;
			}
			else if (time > timeNeeded/2 && time <= timeNeeded){ // second leg of triangle
				
				double maxTriangleVelocity = this.desiredMaxAngularAcceleration*timeNeeded/2;
				
				angularSpeed = -this.desiredMaxAngularAcceleration*(time - timeNeeded/2) + maxTriangleVelocity;
			}
			else {
				
				angularSpeed = 0.0;
			}
		}
		else {//trapezoid
			
			if(time <= criticalTime && time >= 0) {//0 to max angularSpeed
				
				angularSpeed = this.desiredMaxAngularAcceleration*time;
			}
			else if (time > criticalTime && time < (timeNeeded - criticalTime)) {//max angularSpeed
				
				angularSpeed = this.desiredMaxAngularSpeed;
			}
			else if (time >= (timeNeeded - criticalTime) && time <= timeNeeded) {//max angularSpeed to 0
				
				angularSpeed = this.desiredMaxAngularAcceleration*(timeNeeded - time);
			}
			else {//Garbage
				
				angularSpeed = 0;
			}
		}
		
		if (angle < 0) {
			
			return -angularSpeed;
		}
		else {
			
			return angularSpeed;
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
	 * @return the time needed to complete the profile
	 */
	public double timeNeeded() {
		
		return timeNeeded;
	}
	
	/**
	 * @author Liam
	 */
	public double getAngle() {
		
		return angle;
	}
	
	/**
	 * @author Liam
	 */
	public boolean isTriangle() {
		
		return triangle;
	}
}
