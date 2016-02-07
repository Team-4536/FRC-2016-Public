package org.usfirst.frc.team4536.robot;
import java.lang.Math;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;

public class Utilities {
	
	
	/*-----------------------------------------------------Objects---------------------------------------*/
	
	public static PowerDistributionPanel powerDistributionPanel = new PowerDistributionPanel();
	public static Timer timer = new Timer();
	
	/*-----------------------------------------------------variables--------------------------------------------*/
	
	/*-----Cycle Time-----*/
	private static double currentTime, prevTime = 0.0;
	public static double cycleTime = 0.0;
	
	/*-----AccelerationLimit-----*/
	private static double throttleDiff, accelerationLimit = 0.0;
	public static double finalThrottle = 0.0;
	
	/*------------------------------------------------------methods---------------------------------------------*/
	
	/**
	 * @ author Kool Guy Donald Trump
	 * @param input value to be limited.
	 * @param lowerBound minimum value input will be no greater than.
	 * @param upperBound maximum value input will be no less than.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static double limit(double input, double lowerBound, double upperBound) {
		
		if (input < lowerBound) 
			return lowerBound;
		else if (input > upperBound)
			return upperBound;
		else 
			return input;
	}
	
	/**
	 * @author Olivia
	 * @param input value to be limited.
	 * @param bound constrains the input value with a maximum value of bound and a minimum value of negative bound.
	 * @return value after being constrained by upper and lower bounds.
	 */
	public static double limit(double input, double bound) {
		
		return limit(input, -bound, bound);
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * @param input value to be limited
	 * @return value after being constrained with a maximum value of 1 and a minimum value of -1.
	 */
	public static double limit(double input) {
		
		return limit(input, 1);
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * @param input value to be raised to a power (or curved)
	 * @param curve exponent that the method uses to curve the input (curves smaller than 0.1 are invalid)
	 * @return input value raised an exponent (curved)
	 */
	public static double speedCurve(double input, double curve) {
		//negative curves cause asymptotes, leading to overflow errors. Curves smaller than 0.1 aren't very useful.
		double adjustedCurve = limit(curve, 0.1, Double.MAX_VALUE);
		double adjustedInput = limit(input, 1.0);
		//if the input is negative, outputs can be undefined and positive for certain curves
		if(input < 0) {
			return -Math.pow(Math.abs(adjustedInput), adjustedCurve);
		}
		
		return Math.pow(adjustedInput, adjustedCurve);
	}

	/**
	 * @author Kool Guy Donald Trump
	 * @param input value that needs to be of a certain magnitude
	 * @param deadZone magnitude the input should be greater than
	 * @return input if greater than magnitude, 0 if not
	 */
	public static double deadZone(double input, double deadZone){
	
		if((input > -deadZone) && (input < deadZone)) 
			return 0;
		else
			return input;
	}
	
	/**
	 *@ author Kool Guy Donald Trump
	 * Starts the timer.
	 */
	public static void startTimer() {
		
		timer.start();
		prevTime = 0.0;
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * Resets the timer by making the start time the current time so all time values are then compared to that new more recent time.
	 */
	public static void resetTimer() {
		
		timer.reset();
		prevTime = 0.0;
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * Stops the timer.
	 */
	public static void stopTimer() {
		
		timer.stop();
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * @return the current time of the timer in seconds.
	 */
	public static double getTime() {
		
		return timer.get();
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * Updates the cycle time calculation of our code. This should only be called once per cycle or it will be incorrect.
	 */
	public static void updateCycleTime() {
		
		currentTime = getTime();
		cycleTime = currentTime - prevTime;
		prevTime = currentTime;
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * @return The cycle time of our code in seconds.
	 */
	public static double getCycleTime() {
		
		return cycleTime;
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * @param throttle - the throttle of an object.
	 * @param prevThrottle - Throttle Value from previous cycle of code.
	 * @param fullSpeedTime - The amount of time it will take the throttle to reach full speed. Range: [0, infinity+). It is a double. 
	 * @return finalThrottle - returns the throttle adjusted to be within the bounds of the acceleration limit.
	 */
	public static double accelLimit(double throttle, double prevThrottle, double fullSpeedTime) {
		
		finalThrottle = throttle;
		
		throttleDiff = throttle - prevThrottle;

		accelerationLimit = getCycleTime() / fullSpeedTime;

		
		if (throttleDiff > accelerationLimit)
			finalThrottle = prevThrottle + accelerationLimit;
		else if (throttleDiff < -accelerationLimit)
			finalThrottle = prevThrottle - accelerationLimit;
		
		return finalThrottle;
	}
	
	/**
	 * @author Kool Guy Donald Trump
	 * @return The total current drawn from the power distribution board from ALL robot systems.
	 */
	public static double getTotalCurrent() {
		
		return powerDistributionPanel.getTotalCurrent();
	}
	
	/**
	 *@author Liam
	 *@param slot the slot in the power distribution panel 
	 * for which you want to know the current.
	 */
	public static double getCurrent(int slot) {
		
		return powerDistributionPanel.getCurrent(slot);
	}
	
	/**
	 * @author Liam
	 */
	public static double getVoltage() {
		
		return powerDistributionPanel.getVoltage();
	}
	/**
	 *@author Mairead
	 *@param startingAngle The angle the robot is turning from
	 *@param desiredAngle The angle the robot is turning to
	 *@return The difference between those two angles as a number from -180 to 180
	 * Example: If you want to get to 0, and your actual angle is 20, it will return
	 * -20
	 */
	public static double angleDifference(double startingAngle, double desiredAngle){
		double difference;
		difference = startingAngle - desiredAngle;
		if (difference > -180 && difference <= 180)
			return -difference;
		else if (difference <= -180)
			return -(difference + 360);
		else if (difference > 180)
			return -(difference - 360);
		else 
			return 0;
	}
}
