//---------------NEW-DRIVETRAIN-2016-------------------
//-----------------------------------------------------
//----------DONT-CONFUSE-FOR-OLD-DRIVETRAIN------------
//-----------------------------------------------------
//---------------NEW-DRIVETRAIN-2016-------------------

//TODO: incorporate drive encoders and navX

package org.usfirst.frc.team4536.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team4536.robot.*;

public class DriveTrain extends Subsystem {
	
	VictorSP leftBackVictorSP;
	VictorSP leftFrontVictorSP;
	VictorSP rightBackVictorSP;
	VictorSP rightFrontVictorSP;
	
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	/**
	 * @author Max and Audrey 
	 * @param leftVictorSPChannel - The PWM channel of the left VictorSP of the drive train
	 * @param rightVictorSPChannel - THe PWM channel of the right VictorSP of the drive train
	 * @param leftEncoderChannelA - The first channel of the left encoder of the drive train
	 * @param leftEncoderChannelB - The second channel of the left encoder of the drive train
	 * @param rightEncoderChannelA - The first channel of the right encoder of the drive train
	 * @param rightEncoderChannelB - The second channel of the right encoder of the drive train
	 */
	
	public DriveTrain(int leftBackVictorSPChannel, int leftFrontVictorSPChannel, int rightBackVictorSPChannel, int rightFrontVictorSPChannel, int leftEncoderChannelA, int leftEncoderChannelB, int rightEncoderChannelA, int rightEncoderChannelB) {
		
		leftBackVictorSP = new VictorSP(leftBackVictorSPChannel);
		leftFrontVictorSP = new VictorSP(leftFrontVictorSPChannel);
		rightBackVictorSP = new VictorSP(rightBackVictorSPChannel);
		rightFrontVictorSP = new VictorSP(rightFrontVictorSPChannel);
		leftEncoder = new Encoder(leftEncoderChannelA, leftEncoderChannelB);
		rightEncoder = new Encoder(rightEncoderChannelA, rightEncoderChannelB);
		
		leftBackVictorSP.set(0.0);
		leftFrontVictorSP.set(0.0);
		rightBackVictorSP.set(0.0);
		rightFrontVictorSP.set(0.0);
	}
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand())
    	//setDefaultCommand(new Drive());
    }
    
    /**
     * @ author Max
     * @ param leftThrottle - The throttle input into the left motor
     * @ param rightTHrottle - The throttle input into the right motor
     */
    
    public void tankDrive(double leftThrottle, double rightThrottle) {
    	
    	leftBackVictorSP.set(-leftThrottle);
    	leftFrontVictorSP.set(-leftThrottle);
    	rightBackVictorSP.set(rightThrottle);
    	rightFrontVictorSP.set(rightThrottle);
    }
    
    /**
     * @author Max
     * @param forwardThrottle - Throttle for forward motion of the drivetrain (+ forward, - backwards) 
     * @param turnThrottle - Throttle for horizontal motion of the drivetrain (+ right, - left)
     */
    
    public void arcadeDrive(double forwardThrottle, double turnThrottle) {
    	
    	double leftVictorSPThrottle = forwardThrottle + turnThrottle;
    	double rightVictorSPThrottle = -forwardThrottle + turnThrottle;
    	
    	leftBackVictorSP.set(leftVictorSPThrottle);
    	leftFrontVictorSP.set(leftVictorSPThrottle);
    	rightBackVictorSP.set(rightVictorSPThrottle);
    	rightFrontVictorSP.set(rightVictorSPThrottle);
    	
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
		
		return rightEncoder.get()/Constants.DRIVE_ENCODER_PROPORTIONALITY_CONSTANT;
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

}


