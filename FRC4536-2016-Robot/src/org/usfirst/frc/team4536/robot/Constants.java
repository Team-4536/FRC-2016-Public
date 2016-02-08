package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
	
	/*---------------------------------------Drive Train--------------------------------*/

	public static final double SPEED_CURVE = 2.4;
	public static final double DRIVE_TRAIN_MAX_VELOCITY = 4.1; //In feet per seconds
	
	/*---------------------------------------Joystick-----------------------------------*/
	
	public static final double DEAD_ZONE = 0.0;
	
	/*---------------------------------------Encoders-----------------------------------*/
	
	public static final double DRIVE_ENCODER_PROPORTIONALITY_CONSTANT = 19.0; //Ticks per inch
	
	/*-------------------------------------AutoMode Time Outs---------------------------*/
	
	public static final double REACH_DEFENSE_TIME_OUT = 0.9;
	
	/*---------------------------------------Intake-------------------------------------*/
	
	//TODO change these value from test values to values for the intake 
	public static final double INTAKE_SPEED = -0.7;
	public static final double EJECT_SPEED = 0.7;
	public static final double HOLD_SPEED = 0.05;
	
	/*-----Access Values-----*/
	/*@author Liam
	 * If you have displayed a number on the SmartDashboard you may
	 * change it and access its value.
	 */
	
	public static double speedCurve = 2.5;
	
	public static void displaySmartDashboard() {
		
		SmartDashboard.putNumber("Speed Curve: ", 2.5);
	}
	
	public static void updateVariables() {
		
		speedCurve = SmartDashboard.getNumber("Speed Curve: ");
	}
}