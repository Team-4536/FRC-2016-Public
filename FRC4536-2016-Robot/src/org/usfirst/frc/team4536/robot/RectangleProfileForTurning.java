package org.usfirst.frc.team4536.robot;
import org.usfirst.frc.team4536.robot.Constants;

public class RectangleProfileForTurning extends TurnProfile {

	private double angle;
	private double timeNeeded;
	private double stictionAdjustment;
	private double throttle;
	private double desiredMaxAngularVelocity;
	
	/**
	 * @author Mairead
	 * @param angle The angle the robot should turn
	 * (ex: if the robot's at 20 degrees and angle = 50, it will turn to 70 degrees)
	 * @param desiredMaxAngularVelocity The speed the robot should be turning at in degrees per second, always positive
	 */
	public RectangleProfileForTurning (double angle, double desiredMaxAngularVelocity) {

		this.desiredMaxAngularVelocity = desiredMaxAngularVelocity;
		this.angle = angle;
		
		turnProportionality = Constants.TURNING_RECTANGLE_GYRO_PROPORTIONALITY;
		turnIntegral = Constants.TURNING_TRAPEZOID_INTEGRAL;
		timeoutOffset = Constants.TURNING_TRAPEZOID_TIMEOUT_OFFSET;
		angleThreshold = Constants.RECTANGLE_ANGLE_THRESHOLD;
		angularVelocityThreshold = Constants.RECTANGLE_ANGULAR_SPEED_THRESHOLD;
		
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
	 * @author Liam
	 * @param angleDiff The angle the profile should travel in degrees. Negative angles turn counterclockwise, positive turn clockwise.
	 */
	public void setTurnProfile(double angleDiff) {
		
		this.angle = angleDiff;
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
	public double idealVelocity(double time) {
		
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
	public double idealDistance(double time) {
		
		if (time > 0 && time < timeNeeded && angle > 0) {
			return desiredMaxAngularVelocity * time;
		} 
		if (time > 0 && time < timeNeeded && angle < 0) {
			return desiredMaxAngularVelocity * -time;
		} 
		else {
			
			return angle;
		}
	}

    /**
     * @author Audrey
     * @return time needed from the trapezoid profile method in seconds
     */
    public double getTimeNeeded() {
    	
    	return timeNeeded;
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
