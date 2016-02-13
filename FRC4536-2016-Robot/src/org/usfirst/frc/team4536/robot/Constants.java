package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
	
	/*---------------------------------------Drive Train--------------------------------*/

	public static final double SPEED_CURVE = 2.4;
	public static final double FORWARD_STICTION = 0.07; //No climber with fully charged battery
	public static final double TURN_STICTION = 0.3; //No climber with fully charged battery, one motor not functional
	public static final double DRIVE_TRAIN_MAX_VELOCITY = 13.; //Feet per second, measured on blocks, 12.68 Battery Voltage
	public static final double TRAPEZOID_FORWARD_PROPORTIONALITY = 0.05;
	public static final double TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY = -0.015;
	//Zenith
	//TODO change Zenith stiction back
	public static final double ZENITH_FORWARD_STICTION = 0.00; // 0.04
	public static final double ZENITH_TURN_STICTION = 0.1;
	public static final double ZENITH_DRIVE_TRAIN_MAX_VELOCITY = 4.1; //In feet per seconds
	
	/*---------------------------------------Joystick-----------------------------------*/
	
	public static final double DEAD_ZONE = 0.0;
	
	/*---------------------------------------Encoders-----------------------------------*/
	
	public static final double DRIVE_ENCODER_PROPORTIONALITY_CONSTANT = 19.0; //Ticks per inch
	
	/*-------------------------------------AutoMode Time Outs---------------------------*/
	
	public static final double REACH_DEFENSE_TIME_OUT = 0.9;
	
	/*---------------------------------------Intake-------------------------------------*/
	
	//TODO change these value from test values to values for the intake 
	public static final double INTAKE_SPEED = 1.0;
	public static final double EJECT_SPEED = -1.0;
	public static final double HOLD_SPEED = 0.00;
	public static final double INTAKE_STICTION = 0.06; //Full battery
	
	/*-----Access Values-----*/
	/*@author Liam
	 * If you have displayed a number on the SmartDashboard you may
	 * change it and access its value.
	 */
	
	public static double variable1 = 0.0;
	public static double variable2 = 0.0;
	public static double variable3 = 0.0;
	public static double variable4 = 0.0;
	public static double variable5 = 0.0;
	
	public static void displaySmartDashboard() {
		
		SmartDashboard.putNumber("Variable 1: ", 0.0);
		SmartDashboard.putNumber("Variable 2: ", 0.0);
		SmartDashboard.putNumber("Variable 3: ", 0.0);
		SmartDashboard.putNumber("Variable 4: ", 0.0);
		SmartDashboard.putNumber("Variable 5: ", 0.0);
	}
	
	public static void updateVariables() {
		
		variable1 = SmartDashboard.getNumber("Variable 1: ");
		variable2 = SmartDashboard.getNumber("Variable 2: ");
		variable3 = SmartDashboard.getNumber("Variable 3: ");
		variable4 = SmartDashboard.getNumber("Variable 4: ");
		variable5 = SmartDashboard.getNumber("Variable 5: ");
	}
}