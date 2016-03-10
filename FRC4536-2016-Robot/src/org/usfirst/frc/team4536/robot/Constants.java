package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
	
	/*---------------------------------------Drive Train--------------------------------*/

	public static final double SPEED_CURVE_STRAIGHT = 2.4; // Unitless exponent
	public static final double SPEED_CURVE_TURN = 1.5; // Unitless exponent
	public static final double SPEED_CURVE = 2.4; // Unitless exponent
	public static final double SPEED_LIMIT = 1; // In throttle
	public static final double ACCEL_LIMIT_DRIVE = 0.1; // The time it takes to reach full speed in seconds
	public static final double ACCEL_LIMIT_INTAKE = 0.1; // The time it takes to reach full speed in seconds
	public static final double FORWARD_STICTION = 0.07; //No climber with fully charged battery
	public static final double TURN_STICTION = 0.3; //No climber with fully charged battery, one motor not functional
	
	public static final double DRIVE_TRAIN_MAX_VELOCITY = 13.; //Feet per second, measured on blocks, 12.68 Battery Voltage
	public static final double DRIVE_TRAIN_MAX_ANGUAR_VELOCITY = 400; // Degrees per second, measured on carpet, 12.83 Battery Voltage
	public static final double TRAPEZOID_FORWARD_PROPORTIONALITY = 0.05; // units of throttle per inch
	public static final double TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY = -0.03; // Units of throttle per degree
	public static final double TRAPEZOID_PROFILE_TIMEOUT = 2.0; // In seconds
	public static final double TRAPEZOID_DISTANCE_THRESHOLD = 1.0; // In inches
	public static final double TRAPEZOID_SPEED_THRESHOLD = 1.0; // In inches per second
	public static final double TRAPEZOID_ANGLE_THRESHOLD = 1.0; // In degrees
	public static final double TRAPEZOID_ANGULAR_SPEED_THRESHOLD = 1.0; // In degrees per second
	//about the max the robot will reasonably allow is -0.1 (damped oscillation at end)
	
	//Zenith
	public static final double ZENITH_DRIVE_TRAIN_MAX_ANGULAR_VELOCITY = 400; // In degrees per second
	public static final double ZENITH_FORWARD_STICTION = 0.00; // 0.04
	public static final double ZENITH_TURN_STICTION = 0.1; // In throttle
	public static final double ZENITH_DRIVE_TRAIN_MAX_VELOCITY = 4.1; //In feet per seconds
	
	/*---------------------------------------Joystick-----------------------------------*/
	
	public static final double DEAD_ZONE = 0.13; // In throttle
	public static final double SCISSOR_DEAD_ZONE = 0.13; // In throttle
	
	/*---------------------------------------Encoders-----------------------------------*/
	
	public static final double DRIVE_ENCODER_PROPORTIONALITY_CONSTANT = 16.; //Ticks per inch
	
	/*-------------------------------------AutoMode Time Outs---------------------------*/
	
	public static final double REACH_DEFENSE_TIME_OUT = 0.9; // In seconds
	public static final double PICK_UP_BALL_TIME_OUT = 0.1; // In seconds
	public static final double CROSS_LOWBAR_EXTRA_TIME = 1.0; //In seconds
	public static final double CROSS_ROCKWALL_EXTRA_TIME = 2.0; //In seconds
	public static final double CROSS_MOAT_EXTRA_TIME = 4.0;
	
	/*-------------------------------------Auto Mode Distances--------------------------*/
	
	public static final double REACH_DEFENSE_DISTANCE = 3.0; //Feet
	public static final double REACH_DEFENSE_VELOCITY = 1.0; //Feet per second
	public static final double REACH_DEFENSE_ACCELERATION = 2.0; // Feet per second squared
	
	public static final double CROSS_LOWBAR_DISTANCE = 13.0; //Feet
	public static final double CROSS_LOWBAR_VELOCITY = 3.0; //Feet per second
	public static final double CROSS_LOWBAR_ACCEL_LIMIT = 3.0; // Feet per second squared
	
	public static final double CROSS_ROCKWALL_DISTANCE = 12.0; //Feet
	public static final double CROSS_ROCKWALL_VELOCITY = 5.0; //Feet per second
	public static final double CROSS_ROCKWALL_ACCEL_LIMIT = 3.0; // Feet per second squared

	public static final double CROSS_ROUGHTERRAIN_DISTANCE = 13; //Feet
	public static final double CROSS_ROUGHTERRAIN_VELOCITY = 3.0; //Feet per second
	public static final double CROSS_ROUGHTERRAIN_ACCEL_LIMIT = 3.0; // Feet per second squared
	
	public static final double CROSS_RAMPARTS_DISTANCE = 15.0; //Feet
	public static final double CROSS_RAMPARTS_VELOCITY = 5.0; //Feet per second
	public static final double CROSS_RAMPARTS_ACCEL_LIMIT = 3.0; // Feet per second squared
	public static final double CROSS_RAMPARTS_GYRO_PROPORTIONALITY = -0.05;
	
	public static final double CROSS_MOAT_DISTANCE = 16.0; //Feet
	public static final double CROSS_MOAT_VELOCITY = 8.0; //Feet per second
	public static final double CROSS_MOAT_ACCEL_LIMIT = 6.0; // Feet per second squared
	
	/*---------------------------------------Intake-------------------------------------*/
	
	public static final double INTAKE_SPEED = 1.0; // In throttle
	public static final double EJECT_SPEED = -1.0; // In throttle
	public static final double HOLD_SPEED = 0.00; // In throttle
	public static final double INTAKE_STICTION = 0.06; //Full battery
	public static final double INTAKE_SPEED_CURVE = 1; // Unitless exponent
	
	/*----------------------------------Auto Intake Constants----------------------------*/
	
	public static final int AUTO_INTAKE_TIMEOUT = 5;
	public static final double INTAKE_DESIRED_DISTANCE = 3;
	public static final double P_CONSTANT = 0.16;
	
	/*-----------------------------------Sensor Constants-------------------------------*/
	
	public static final double MAX_ULTRA_CONVERSION = 95.238;
	
	/*-----Access Values-----*/
	/*@author Liam
	 * If you have displayed a number on the SmartDashboard you may
	 * change it and access its value. This allows for rapid development
	 * of constants because we can tweak values without re-deploying code.
	 * We can also run test cases quickly, all from the SmartDashboard.
	 */
	
	public static double variable1 = 0.0;
	public static double variable2 = 0.0;
	public static double variable3 = 0.0;
	public static double variable4 = 0.0;
	public static double variable5 = 0.0;
	public static boolean variable6 = true;
	
	public static void displaySmartDashboard() {
		
		SmartDashboard.putNumber("Variable 1: ", 0.0);
		SmartDashboard.putNumber("Variable 2: ", 0.0);
		SmartDashboard.putNumber("Variable 3: ", 0.0);
		SmartDashboard.putNumber("Variable 4: ", 0.0);
		SmartDashboard.putNumber("Variable 5: ", 0.0);
		SmartDashboard.putBoolean("Variable 6: ", true);
	}
	
	public static void updateVariables() {
		
		variable1 = SmartDashboard.getNumber("Variable 1: ");
		variable2 = SmartDashboard.getNumber("Variable 2: ");
		variable3 = SmartDashboard.getNumber("Variable 3: ");
		variable4 = SmartDashboard.getNumber("Variable 4: ");
		variable5 = SmartDashboard.getNumber("Variable 5: ");
		variable6 = SmartDashboard.getBoolean("Variable 6: ");
	}
}
