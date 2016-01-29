//---------------NEW-DRIVETRAIN-2016-------------------
//-----------------------------------------------------
//----------DONT-CONFUSE-FOR-OLD-DRIVETRAIN------------
//-----------------------------------------------------
//---------------NEW-DRIVETRAIN-2016-------------------

//TODO: incorporate drive encoders and navX

package org.usfirst.frc.team4536.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team4536.robot.*;

public class DriveTrain extends Subsystem {
	
	Talon leftTalon;
	Talon rightTalon;
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	double prevDistance = 0.0;
	double currentDistance = 0.0;
	double distanceDifference = 0.0;
	
	/**
	 * @author Max and Audrey 
	 * @param leftTalonChannel - The PWM channel of the left talon of the drive train
	 * @param rightTalonChannel - THe PWM channel of the right talon of the drive train
	 * @param leftEncoderChannelA - The first channel of the left encoder of the drive train
	 * @param leftEncoderChannelB - The second channel of the left encoder of the drive train
	 * @param rightEncoderChannelA - The first channel of the right encoder of the drive train
	 * @param rightEncoderChannelB - The second channel of the right encoder of the drive train
	 */
	
	public DriveTrain(int leftTalonChannel, int rightTalonChannel, int leftEncoderChannelA, int leftEncoderChannelB, int rightEncoderChannelA, int rightEncoderChannelB) {
		
		leftTalon = new Talon(leftTalonChannel);
		rightTalon = new Talon(rightTalonChannel);
		leftEncoder = new Encoder(leftEncoderChannelA, leftEncoderChannelB);
		rightEncoder = new Encoder(rightEncoderChannelA, rightEncoderChannelB);
		
    	leftTalon.set(0.0); //Why are these indents so funky?
    	rightTalon.set(0.0);
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
    	
    	leftTalon.set(-leftThrottle);
    	rightTalon.set(rightThrottle);
    }
    
    /**
     * @author Max
     * @param forwardThrottle - Throttle for forward motion of the drivetrain (+ forward, - backwards) 
     * @param turnThrottle - Throttle for horizontal motion of the drivetrain (+ right, - left)
     */
    
    public void arcadeDrive(double forwardThrottle, double turnThrottle) {
    	
    	double leftTalonThrottle = -forwardThrottle + turnThrottle;
    	double rightTalonThrottle = forwardThrottle + turnThrottle;
    	
    	leftTalon.set(leftTalonThrottle);
    	rightTalon.set(rightTalonThrottle);
    	
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


