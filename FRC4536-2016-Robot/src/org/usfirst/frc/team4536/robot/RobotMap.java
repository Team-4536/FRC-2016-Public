package org.usfirst.frc.team4536.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
	
	private RobotMap() {} // prevent object construction which is useless. All variables and methods are static.
	
	/*-------------------------------------Motor Channels------------------------------------*/	

    public static final int LEFT_MOTOR_FRONT = 1;
    public static final int LEFT_MOTOR_BACK = 0;
    
    public static final int RIGHT_MOTOR_FRONT = 2;
    public static final int RIGHT_MOTOR_BACK = 3;
    
    public static final int INTAKE_MOTOR_CHANNEL = 4;
    
    public static final int SCISSOR_MOTOR = 5;
    
    /*-------------------------------------Power Distribution Panels-------------------------*/
    
    public static final int PDP_SCISSOR_LIFT = 0;
    public static final int PDP_RIGHT_MOTOR_FRONT = 2;
    public static final int PDP_INTAKE = 12;
    public static final int PDP_RIGHT_MOTOR_BACK = 13;
    public static final int PDP_LEFT_MOTOR_FRONT = 14;
    public static final int PDP_LEFT_MOTOR_BACK = 15;
    
    /*-------------------------------------Joystick Ports---------------------------------*/
    public static final int MAIN_STICK = 0; // (Also the left stick for tank drive)
    public static final int SECONDARY_STICK = 1; // (Also the right stick for tank drive)
    public static final int TERTIARY_STICK = 2; //Scissor Lift
    
    /*-------------------------------------Joystick Buttons---------------------------------*/
    public static final int INTAKE_BUTTON_NUMBER = 5;
    public static final int EJECT_BUTTON_NUMBER = 6;
    public static final int HOLD_BUTTON_NUMBER = 7;
    public static final int AUTO_INTAKE_BUTTON_NUMBER = 4;
    public static final int PLOP_BUTTON_NUMBER = 12;
    public static final int DEPLOY_SCISSORS_BUTTON_NUMBER = 1;
    public static final int FLIP_JOYSTICK = 7;
    
    public static final int HOLD_AT_CURRENT_ANGLE = 1;
    public static final int HOLD_AT_0_DEGREES = 3;
    public static final int HOLD_AT_180_DEGREES = 2;    
    public static final int HOLD_AT_ANGLE_FOR_LEFT_GOAL = 5;
    public static final int HOLD_AT_ANGLE_FOR_RIGHT_GOAL = 4;
    
    
	/*-------------------------------------Relay Solenoid-----------------*/
	
	public static final int SCISSOR_RELAY = 0; //these go in the relay port, 
	public static final int INTAKE_RELAY = 1; //electricians; not PWM or DIM 
	
    /*-------------------------------------Digital Sensor Channels---------------------------------*/	
	
	public static final int LEFT_ENCODER_CHANNEL_A = 8; //1 yellow wire in signal for left encoder
	public static final int LEFT_ENCODER_CHANNEL_B = 9; //Set of 3 wires blue in signal, then orange and brown for left encoder
	public static final int RIGHT_ENCODER_CHANNEL_A = 6; //1 yellow wire in signal for right encoder
	public static final int RIGHT_ENCODER_CHANNEL_B = 7; //Set of 3 wires blue in signal, then orange and brown for right encoder

	 /*-------------------------------------Analog Sensor Channels---------------------------------*/
	public static final int FRONT_ULTRA_CHANNEL = 0;
	public static final int BACK_ULTRA_CHANNEL = 1;
	public static final int LEFT_IR_CHANNEL = 2;
	public static final int INTAKE_IR_CHANNEL = 3;
	
}
