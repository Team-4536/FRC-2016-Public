package org.usfirst.frc.team4536.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	/*-------------------------------------Joystick Ports---------------------------------*/
	
	public static final int MAIN_STICK = 0;
	public static final int SECONDARY_STICK = 1;
	
	/*-------------------------------------Intake-----------------------------------------*/
	
	//TODO Set it to the correct port on the robot
	public static final int INTAKE_CHANNEL = 12;
}
