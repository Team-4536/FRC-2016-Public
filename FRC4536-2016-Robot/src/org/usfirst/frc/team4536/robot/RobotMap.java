package org.usfirst.frc.team4536.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	/*-------------------------------------Motor Channels------------------------------------*/	
    public static final int LEFT_MOTOR = 1;
    public static final int RIGHT_MOTOR = 0;
    
    /*-------------------------------------Joystick Ports---------------------------------*/
    public static final int MAIN_STICK = 0; // (Also the left stick for tank drive)
    public static final int SECONDARY_STICK = 1; // (Also the right stick for tank drive)
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static int leftSolenoid = 2; //Zenith = 2; Onyx = 4?
	public static int rightSolenoid = 3; //Zenith = 3; Onyx = 7?
	
    /*-------------------------------------Sensor Channels---------------------------------*/	
	public static final int LEFT_ENCODER_CHANNEL_A = 8;
	public static final int LEFT_ENCODER_CHANNEL_B = 9;
	public static final int RIGHT_ENCODER_CHANNEL_A = 2;
	public static final int RIGHT_ENCODER_CHANNEL_B = 7;
	public static final int GYRO_CHANNEL = 0;
	//All the above are for Zenith
}
