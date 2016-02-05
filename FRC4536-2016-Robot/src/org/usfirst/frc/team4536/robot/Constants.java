package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
	
	/*---------------------------------------Drive Train--------------------------------*/

	public static final double SPEED_CURVE = 0.0;
	
	/*---------------------------------------Joystick-----------------------------------*/
	
	public static final double DEAD_ZONE = 0.0;
	
	/*---------------------------------------Encoders-----------------------------------*/
	
	public static final double DRIVE_ENCODER_PROPORTIONALITY_CONSTANT = 19.0; //Ticks per inch
	
	public static final int LEFT_ENCODER_CHANNEL_A = 8; //Set of 3 wires in one port for left encoder
	public static final int LEFT_ENCODER_CHANNEL_B = 9; //Set of 3 wires in one port for left encoder
	public static final int RIGHT_ENCODER_CHANNEL_A = 2; //Set of 3 wires in one port for right encoder
	public static final int RIGHT_ENCODER_CHANNEL_B = 7; //Set of 3 wires in one port for right encoder
	
	/*-------------------------------------AutoMode Time Outs---------------------------*/
	
	public static final double REACH_DEFENSE_TIME_OUT = 0.9;
	
	/*---------------------------------------Intake-------------------------------------*/
	
	//TODO change these value from test values to values for the intake 
	public static final double INTAKE_SPEED = -0.7;
	public static final double EJECT_SPEED = 0.7;
	public static final double HOLD_SPEED = 0.05;
	
	
	/*-----SmartDashboard Variables-----*/
	
	public static double number;
	
	/*SmartDashboard.putNumber("Number: ", 0);
	
	public void readSmartDashboardValues() {
		
		Smart 
	}*/
}
