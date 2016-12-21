package org.usfirst.frc.team4536.robot;

import java.lang.Math;
import org.usfirst.frc.team4536.robot.commands.CommandBase;

/**
 * 
 * @author Audrey
 *
 */
public class TurningTrapezoidProfile extends Profile {
	
	private double angle; // angle The angle the profile should travel in degrees. Negative angles turn left, positive right.
	private double timeNeeded; // The time needed to execute the profile In seconds
	private double desiredMaxAngularSpeed; // The maximum angular speed the profile may achieve in degrees per second. Angular speed is a scalar so it's always positive because we don't care about direction.
	private double desiredMaxAngularAcceleration; // The maximum angular acceleration the angular speed can change by in degrees per second squared. We treat acceleration as the raw change in speed and thus as a scalar so it is always positive.
	private double criticalAngle; // This determines whether the profile is a triangle or a trapezoid.
	private double criticalTime; // This is the time it takes to reach maxSpeed if it is reached
	private boolean triangle; // Whether the profile develops a triangle or trapezoid profile
	
	/**
	 * @author Audrey
	 * @param angleDiff The angle the profile travels in degrees. - angles turn counterclockwise, + turn clockwise.
	 * @param maxAngularSpeed The maximum speed that may be achieved in degrees per second. Always positive.
	 * @param maxAngularAcceleration The maximum angular acceleration in degrees per second squared. Always positive.
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
	 * @author Audrey
	 * @param angleDiff The angle the profile should travel in degrees. - angles turn counterclockwise, + turn clockwise.
	 */
	public TurningTrapezoidProfile (double angle) {
		
		this(angle, Constants.TURNING_TRAPEZOID_DEFAULT_ANGULAR_SPEED, Constants.TURNING_TRAPEZOID_DEFAULT_ANGULAR_ACCELERATION);
	}
	
	/**
	 * @author Audrey
	 * @param angleDiff The angle the profile should travel in degrees. - turn counterclockwise, + turn clockwise.
	 * @param maxAngularSpeed The maximum speed the profile may achieve in degrees per second. Always positive.
	 * @param maxAngularAcceleration The maximum angular acceleration in degrees per second squared. Always positive.
	 */
	public void setAngle(double angle) {
		
		this.angle = angle;
		
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
	 * @author Audrey
	 */
	public double leftThrottle(double time) {
		
		return turnThrottle(time);
	}
	
	/**
	 * @author Audrey
	 */
	public double rightThrottle(double time) {
		
		return -turnThrottle(time);
	}
		
	/**
	 * @author Audrey
	 * @param The amount of time since the profile has started
	 * @returns The throttle at which the robot should be
	 */
	public double turnThrottle(double time) {

		return Utilities.adjustForStiction(idealAngularVelocity(time), Constants.TURN_STICTION, Constants.DRIVE_TRAIN_MAX_ANGULAR_VELOCITY);
	}
	
	/**
	 * @author Audrey
	 * @return timeNeeded the theoretical time need for the profile to execute without correction
	 */
	public double getTimeNeeded() {
		
		return this.timeNeeded;
	}
	
	/**
	 * @author Audrey
	 * For compatibility for DriveProfile Command execution, dummy method for this profile
	 */
	public double idealVelocity(double time) {
		
		return 0.0;
	}
	
	/**
	 * @author Audrey
	 * @param time The amount of time since the profile has started
	 * @returns The angular velocity at which the robot should be
	 */
	public double idealAngularVelocity(double time) {
		
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
	 * @author Audrey
	 * @return the distance the left side should have traveled in inches. This profile doesn't care about distance.
	 */
	public double idealLeftDistance(double time) {
		
		return CommandBase.driveTrain.getLeftEncoder();
		//return 2*Math.PI*idealAngle(time)*(Constants.WHEEL_DISTANCE_FROM_ROBOT_CENTER/12)/360;
	}
	
	/**
	 * @author Audrey
	 * @return the distance the right side should have traveled in inches. This profile doesn't care about distance.
	 */
	public double idealRightDistance(double time) {
		
		return CommandBase.driveTrain.getRightEncoder();
	}
	
	/**
	 * @author Audrey
	 * @return angle the robot at which should be by that time
	 */
	public double idealAngle(double time) {
		
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
	 * @author Audrey
	 * @return triangle whether the profile has developed a triangle (true)or trapezoid profile(false)
	 */
	public boolean isTriangle() {
		
		return triangle;
	}
	
	/**
	 * @author Audrey
	 * For compatibility for DriveProfile Command execution, dummy method for this profile
	 */
	public double getLeftDistance() {
		
		return 2*Math.PI*getAngle()*(Constants.WHEEL_DISTANCE_FROM_ROBOT_CENTER/12)/360;
	}
	
	/**
	 * @author Audrey
	 * For compatibility for DriveProfile Command execution, dummy method for this profile
	 */
	public double getRightDistance() {
		
		return -2*Math.PI*getAngle()*(Constants.WHEEL_DISTANCE_FROM_ROBOT_CENTER/12)/360;
	}
	
	/**
	 * @author Audrey
	 * @return the angle to which the profile will travel
	 */
	public double getAngle() {
		
		return angle;
	}
}
