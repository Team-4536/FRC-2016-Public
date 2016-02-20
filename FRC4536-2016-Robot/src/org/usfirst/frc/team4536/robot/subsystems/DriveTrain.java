package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.AnalogInput;
import org.usfirst.frc.team4536.robot.*;
import org.usfirst.frc.team4536.robot.commands.DriveTrainCommand;
import com.kauailabs.navx.frc.AHRS;

public class DriveTrain extends Subsystem {
	
	VictorSP leftBackVictorSP;
	VictorSP leftFrontVictorSP;
	VictorSP rightBackVictorSP;
	VictorSP rightFrontVictorSP;
	Encoder leftEncoder;
	Encoder rightEncoder;
	AHRS navX;
	AnalogInput frontUltra;
	AnalogInput backUltra;
	AnalogInput leftIR;
	
	public double oldForwardThrottle;
	public double oldTurnThrottle;
	
	/*---------Sensor Values---------*/
	
	double backDist, frontDist; //These are in feet
	double leftDist; //This is in inches
	double prevNavXYaw;
	
	/**
	 * @author Noah
	 * @param leftBackVictorSPChannel
	 * @param leftFrontVictorSPChannel
	 * @param rightBackVictorSPChannel
	 * @param rightFrontVictorSPChannel
	 * @param leftEncoderChannelA
	 * @param leftEncoderChannelB
	 * @param rightEncoderChannelA
	 * @param rightEncoderChannelB
	 * @param frontUltraChannel
	 * @param backUltraChannel
	 * @param leftIRChannel
	 */
	
	public DriveTrain(  int leftBackVictorSPChannel,  int leftFrontVictorSPChannel,
						int rightBackVictorSPChannel, int rightFrontVictorSPChannel,
						int leftEncoderChannelA,      int leftEncoderChannelB,
						int rightEncoderChannelA,     int rightEncoderChannelB,
						int frontUltraChannel,		  int backUltraChannel,
						int leftIRChannel) {
		
		leftBackVictorSP = new VictorSP(leftBackVictorSPChannel);
		leftFrontVictorSP = new VictorSP(leftFrontVictorSPChannel);
		rightBackVictorSP = new VictorSP(rightBackVictorSPChannel);
		rightFrontVictorSP = new VictorSP(rightFrontVictorSPChannel);
		leftEncoder = new Encoder(leftEncoderChannelA, leftEncoderChannelB);
		rightEncoder = new Encoder(rightEncoderChannelA, rightEncoderChannelB);
		frontUltra = new AnalogInput(frontUltraChannel);
		backUltra = new AnalogInput(backUltraChannel);
		leftIR = new AnalogInput(leftIRChannel);

		
		try {
	          navX = new AHRS(SPI.Port.kMXP); 
	      } catch (RuntimeException ex ) {
	          DriverStation.reportError("Error instantiating navX-MXP:  " + ex.getMessage(), true);
	      }
		
		leftBackVictorSP.set(0.0);
		leftFrontVictorSP.set(0.0);
		rightBackVictorSP.set(0.0);
		rightFrontVictorSP.set(0.0);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveTrainCommand());
    }
    
    /**
     * @ author Max and Liam
     * @ param leftThrottle - The throttle input into the left motors, positive value is left/forward
     * @ param rightThrottle - The throttle input into the right motors, positive value is right/forward
     */
    public void tankDrive(double leftThrottle, double rightThrottle) {
    	leftBackVictorSP.set(leftThrottle);
    	leftFrontVictorSP.set(leftThrottle);
    	rightBackVictorSP.set(-rightThrottle);
    	rightFrontVictorSP.set(-rightThrottle);
    }
    
    /**
     * @author Max and Liam
     * @param forwardThrottle - Throttle for forward motion of the drivetrain (+ forward, - backwards) 
     * @param turnThrottle - Throttle for horizontal motion of the drivetrain (+ right, - left)
     */
    public void arcadeDrive(double forwardThrottle, double turnThrottle) {

    	oldForwardThrottle = forwardThrottle;
    	oldTurnThrottle = turnThrottle;
    	
    	tankDrive(forwardThrottle + turnThrottle, forwardThrottle - turnThrottle);
    	
    }
    
    /**
     * @author Sheila and Audrey
     * @param forwardThrottle - see arcadeDrive
     * @param turnThrottle - see arcadeDrive
     */
    public void arcadeDriveAccelLimit(double forwardThrottle, double turnThrottle) {
    	System.out.println("Forward Throttle: "+ forwardThrottle);
    	System.out.println("Old Forward Throttle: "+ oldForwardThrottle);
    	System.out.println("Turn Throttle: "+ turnThrottle);
    	System.out.println("Old Turn Throttle: "+ oldTurnThrottle);
    	forwardThrottle = Utilities.accelLimit(forwardThrottle, oldForwardThrottle, Constants.ACCEL_LIMIT_DRIVE);
    	turnThrottle = Utilities.accelLimit(turnThrottle, oldTurnThrottle, Constants.ACCEL_LIMIT_DRIVE);

    
    	arcadeDrive(forwardThrottle, turnThrottle);
    }
    
    /**
     * @author Audrey
     * @return right encoder distance in inches
     */
    public double getEncoder() {
    	
    	return getRightEncoder();
    }
    
    /**
     * @author Audrey
     * @return right encoder rate in inches per second
     */
    public double getRate() {
    	
    	return getRightRate();
    }
    
    /**
     * @author Audrey
     * @return left encoder distance as inches
     */
	public double getLeftEncoder() {
		
		return leftEncoder.get()/Constants.DRIVE_ENCODER_PROPORTIONALITY_CONSTANT;
	}

	/**
	 * @author Audrey
	 * @return right encoder distance as inches
	 */
	public double getRightEncoder() {
		
		return -rightEncoder.get()/Constants.DRIVE_ENCODER_PROPORTIONALITY_CONSTANT;
	}

	/**
	 * @author Audrey
	 * @return right encoder velocity/rate in inches per second
	 */
	public double getRightRate() {
		
		return rightEncoder.getRate()/Constants.DRIVE_ENCODER_PROPORTIONALITY_CONSTANT;
	}
	
	/**
	 * @author Audrey
	 * @return left encoder velocity/rate in inches per second
	 */
	public double getLeftRate() {
		
		return leftEncoder.getRate()/Constants.DRIVE_ENCODER_PROPORTIONALITY_CONSTANT;
	}
	
	/**
	 * @author Audrey
	 * Resets left and right encoders
	 */
	public void resetEncoders(){
		
		resetLeftEncoder();
		resetRightEncoder();
		
	}
	
	/**
	 * @author Noah
	 * Resets the left encoder
	 */
	public void resetLeftEncoder() {
		
		leftEncoder.reset();
	}	
	
	/**
	 * @author Noah
	 * Resets the right encoder
	 */
	public void resetRightEncoder() {
		
		rightEncoder.reset();
	}
	
	/**
	 * @author Liam
	 * 
	 */
	public void resetAccelValues() {
		
		oldForwardThrottle = 0.0;
		oldTurnThrottle = 0.0;
	}

	/**
	 * @author Audrey
	 * @return NavX Yaw or the angle of the robot around a vertical axis
	 * @return If output is positive, robot is turning right
	 * @return If output is negative, robot is turning left
	 * Range of [-180, 180)
	 */
	public double getNavXYaw(){
		
		return navX.getYaw();
	}
	
	/**
	 * @author Audrey
	 * @return NavX Pitch or the angle of the robot around an axis from left to right
	 * @return If output is positive, robot is tilting forward
	 * @return If output is negative, robot is tilting backwards
	 */
	public double getNavXPitch(){
		
		return navX.getPitch();
	}
	
	/**
	 * @author Audrey
	 * @return NavX Roll or the angle of the robot around an axis from front to back
	 * @return If output is positive, robot is tilting right
	 * @return If output is negative, robot is tilting left
	 */
	public double getNavXRoll(){
		
		return navX.getRoll();
	}

	/**
	 * @author Liam
	 * Resets the NavX
	 */
	public void resetNavX() {
		
		navX.reset();
	}
	
	/**
	 * @author Liam
	 * @return the rate of turning in degrees per second
	 */
	public double getYawRate() {
		
		return navX.getRawGyroZ();
	}
	
	/**
	 * @author Mairead
	 * @return The angle the robot is at from 0 to 360
	 */
	public double getAngle(){
		double modifiedYaw;
		modifiedYaw = navX.getYaw()%360;
		
		if (modifiedYaw < 0)
			return(modifiedYaw + 360);
		else
			return (modifiedYaw);	
	}
	
	/**
	 * @author Noah
	 * @return The distance in front of the robot in feet
	 */
	public double getFrontDist() {
		frontDist = frontUltra.getValue() / Constants.MAX_ULTRA_CONVERSION;
		return frontDist;
	}
	
	/**
	 * @author Noah
	 * @return The distance behind the robot in feet
	 */
	public double getBackDist() {
		backDist = backUltra.getValue() / Constants.MAX_ULTRA_CONVERSION;
		return backDist;
	}
	
	/**
	 * @author Noah
	 * @return The distance to the left of the robot in inches
	 */
	public double getleftDist() {
		leftDist = 21 - (10 * (leftIR.getVoltage()));
		return leftDist;
	}

}


