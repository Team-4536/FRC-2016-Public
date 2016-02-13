package org.usfirst.frc.team4536.robot;
import java.lang.Math;

/**
 * 
 * @author Liam
 *
 */
public class TrapezoidProfile {

	public double distance;
	public double timeNeeded;
	public double desiredMaxSpeed;
	public double desiredMaxAcceleration;
	public double criticalDistance; //This determines whether the profile is a triangle or a trapezoid.
	public double criticalTime; //This is the time it takes to reach maxSpeed
	public boolean triangle;
	
	public TrapezoidProfile (double distance, double maxSpeed, double maxAcceleration) {
		
		this.distance = distance;
		this.desiredMaxSpeed = maxSpeed;
		this.desiredMaxAcceleration = maxAcceleration;
		
		criticalTime = this.desiredMaxSpeed/this.desiredMaxAcceleration;
		criticalDistance = criticalTime * this.desiredMaxSpeed/2;
		
 		if (this.distance > criticalDistance) {
			
			triangle = false;
		}
		else {
			
			triangle = true;
		}
		
		if (triangle) {
			
			this.timeNeeded = 2*Math.sqrt(Math.abs(this.distance/this.desiredMaxAcceleration));
		}
		else {
			
			this.timeNeeded = (2*criticalTime) + ((Math.abs(this.distance) - 2*criticalDistance)/this.desiredMaxSpeed);
		}
	}
		
		/**
		 * @author Liam
		 * @param time The amount of time since the profile has started
		 * @returns The throttle the robot should be at
		 */
		public double throttle(double time) {
			
			System.out.println(Utilities.adjustForStiction(idealVelocity(time), Constants.FORWARD_STICTION, Constants.ZENITH_DRIVE_TRAIN_MAX_VELOCITY));

			return Utilities.adjustForStiction(idealVelocity(time), Constants.ZENITH_FORWARD_STICTION, Constants.ZENITH_DRIVE_TRAIN_MAX_VELOCITY);
		}
		
		public double getTimeNeeded() {
			
			return this.timeNeeded;
		}
		
		/**
		 * @author Liam
		 * @param time The amount of time since the profile has started
		 * @returns The veloctiy the robot should be at
		 */
		public double idealVelocity(double time) {
			
			double velocity;
			
			if (triangle) {
				
				if(time <= timeNeeded/2 && time > 0) {
					
					velocity =  this.desiredMaxAcceleration*time;
				}
				else if (time > timeNeeded/2 && time <= timeNeeded){
					
					double maxTriangleVelocity = this.desiredMaxAcceleration*timeNeeded/2;
					
					velocity = -this.desiredMaxAcceleration*(timeNeeded - time) + 2*maxTriangleVelocity;
				}
				else {
					
					velocity = 0.0;
				}
			}
			else {//trapezoid
				
				if(time <= criticalTime && time >= 0) {//0 to max velocity
					
					velocity = this.desiredMaxAcceleration*time;
				}
				else if (time > criticalTime && time < (timeNeeded - criticalTime)) {//max velocity
					
					velocity = this.desiredMaxSpeed;
				}
				else if (time >= (timeNeeded - criticalTime) && time <= timeNeeded) {//max velocity to 0
					
					velocity = this.desiredMaxAcceleration*(timeNeeded - time);
				}
				else {//Garbage
					
					velocity = 0;
				}
			}
			
			if (distance < 0) {
				
				return -velocity;
			}
			else {
				
				return velocity;
			}
		}
		
		/**
		 * @author Liam
		 * @return distance the robot should be at by that time
		 */
		public double idealDistance(double time) {
			
			double distance;
			
			if (triangle) {
				
				if (time >= 0 && time <= timeNeeded/2) { // First Half, before timeNeeded divided by 2
					
					distance = idealVelocity(time) * time / 2;
				}
				else if (time > timeNeeded/2 && time <= timeNeeded) { // Second Half, after timeNeeded divided by 2
					
					distance = this.distance - (idealVelocity(timeNeeded-time)* (timeNeeded-time))/2;
				}
				else if (time > timeNeeded) { // TimeNeeded or greater
					
					distance = this.distance;
				}
				else { // Negative Time
					
					distance = 0;
				}
			}
			else { // Trapezoid
				
				if (time >= 0 && time <= criticalTime) { // The first leg of the trapezoid
					
					distance = idealVelocity(time)*time/2;
				}
				else if (time > criticalTime && time <= (timeNeeded - criticalTime)) { // The body of the trapezoid
					
					distance = this.desiredMaxSpeed * (time - criticalTime) + criticalDistance;
				}
				else if (time > (timeNeeded - criticalTime) && time <= timeNeeded) { // The last leg of the trapezoid
					
					distance = this.distance - (idealVelocity(timeNeeded - time) * (timeNeeded - time))/2;
				}
				else if (time > timeNeeded) { // After timeNeeded when the distance should have been covered
					
					distance = this.distance;
				}
				else { // Garbage negative values
					
					distance = 0;
				}
			}
			
			return distance;
		}
		
		public boolean isTriangle() {
			
			return triangle;
		}
}
