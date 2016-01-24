//---------------NEW-DRIVETRAIN-2016-------------------
//-----------------------------------------------------
//----------DONT-CONFUSE-FOR-OLD-DRIVETRAIN------------
//-----------------------------------------------------
//---------------NEW-DRIVETRAIN-2016-------------------

//TODO: incorporate drive encoders and navX

package org.usfirst.frc.team4536.robot.subsystems;
import org.usfirst.frc.team4536.robot.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain extends Subsystem {
	
	Talon leftTalon;
	Talon rightTalon;
	
	/**
	 * @author Max
	 * @param leftTalonChannel - The PWM channel of the left talon of the drive train
	 * @param rightTalonChannel - THe PWM channel of the right talon of the drive train
	 */
	
	public DriveTrain(int leftTalonChannel, int rightTalonChannel) {
		
		leftTalon = new Talon(leftTalonChannel);
		rightTalon = new Talon(rightTalonChannel);
		
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
}


