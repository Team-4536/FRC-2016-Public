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
	public static final double TURN_STICTION = 0.31; //full robot, 12.8 voltage battery
	
	public static final double DRIVE_TRAIN_MAX_VELOCITY = 13.; //Feet per second, measured on blocks, 12.68 Battery Voltage
	public static final double DRIVE_TRAIN_MAX_ANGULAR_VELOCITY = 400; // Degrees per second, measured on carpet, 12.83 Battery Voltage
	
	public static final int FLIP_DIRECTIONS_TIMEOUT = 1;
	
	/*--------------------------------------Profiles----------------------------------*/
	
	//Trapezoid
	
	public static final double TRAPEZOID_FORWARD_PROPORTIONALITY = 0.07; // units of throttle per inch
	public static final double TRAPEZOID_FORWARD_GYRO_PROPORTIONALITY = -0.03; // Units of throttle per degree
	public static final double TRAPEZOID_PROFILE_TIMEOUT_OFFSET = 0.5; // In seconds. Increases the timeout which is timeNeeded by this offset.
	public static final double TRAPEZOID_DISTANCE_THRESHOLD = 2.0; // In inches
	public static final double TRAPEZOID_SPEED_THRESHOLD = 1.0; // In inches per second
	public static final double TRAPEZOID_ANGLE_THRESHOLD = 2.0; // In degrees
	public static final double TRAPEZOID_ANGULAR_SPEED_THRESHOLD = 1.0; // In degrees per second
	public static final double TRAPEZOID_DEFAULT_SPEED = 10; // feet per second
	public static final double TRAPEZOID_DEFAULT_ACCELERATION = 4; // feet per second squared
	//about the max the robot will reasonably allow is -0.1 (damped oscillation at end)
	
	//Turning Trapezoid
	public static final double TURNING_TRAPEOID_GYRO_PROPORTIONALITY = 0.04; // Throttle per degree
	public static final double TURNING_TRAPEZOID_TIMEOUT_OFFSET = 0.5; // in seconds, added to the base timeout time which is the time needed
	public static final double TURNING_TRAPEZOID_ANGLE_THRESHOLD = 2.0; // in degrees
	public static final double TURNING_TRAPEZOID_ANGULAR_SPEED_THRESHOLD = 1.0; // in degrees per second
	public static final double TURNING_TRAPEZOID_DEFAULT_ANGULAR_SPEED = 200; // in degrees per second
	public static final double TURNING_TRAPEZOID_DEFAULT_ANGULAR_ACCELERATION = 90; // in degrees per second squared
	
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
	
	public static final double REACH_DEFENSE_TIME_OUT = 0.9; // 0.9 In seconds
	public static final double PICK_UP_BALL_TIME_OUT = 0.1; // In seconds
	
	public static final double CROSS_LOWBAR_EXTRA_TIME = 1.0; // In seconds
	public static final double CROSS_ROCKWALL_EXTRA_TIME = 2.0; // In seconds
	public static final double CROSS_MOAT_EXTRA_TIME = 4.0; //
	
	/*-------------------------------------Auto Mode Distances--------------------------*/
	
	public static final double LOW_BAR_LOW_GOAL_FIRST_LEG_DISTANCE = 4.0; // in feet
	public static final double LOW_BAR_lOW_GOAL_SECOND_LEG_DISTANCE = 6.0; // in feet
	public static final double LOW_BAR_LOW_GOAL_FIRST_LEG_ANGLE = 10.0; // in degrees
	public static final double LOW_BAR_LOW_GOAL_SECOND_LEG_ANGLE = 50.0; // in degrees
	
	public static final double SPY_BOT_LOW_GOAL_FIRST_LEG_DISTANCE = 4.5; // in feet 
	public static final double SPY_BOT_LOW_GOAL_SECOND_LEG_DISTANCE = 5.3; // in feet
	public static final double SPY_BOT_LOW_GOAL_TURN_ANGLE = -75; // in degrees
	public static final double SPY_BOT_LOW_GOAL_MAX_ANGULAR_SPEED = 150; // in degrees per second
	public static final double SPY_BOT_LOW_GOAL_MAX_ANGULAR_ACCELERATION = 90; // in degrees per second squared
	
	public static final double REACH_DEFENSE_DISTANCE = 3.0; //Feet
	public static final double REACH_DEFENSE_VELOCITY = 1.0; //Feet per second
	public static final double REACH_DEFENSE_ACCELERATION = 2.0; // Feet per second squared
	
	public static final double CROSS_LOWBAR_DISTANCE = 13.0; //Feet
	public static final double CROSS_LOWBAR_VELOCITY = 5.0; //Feet per second
	public static final double CROSS_LOWBAR_ACCEL_LIMIT = 4.0; // Feet per second squared
	
	public static final double CROSS_ROCKWALL_DISTANCE = 13.5; //Feet
	public static final double CROSS_ROCKWALL_VELOCITY = 5.0; //Feet per second
	public static final double CROSS_ROCKWALL_ACCEL_LIMIT = 3.0; // Feet per second squared

	public static final double CROSS_ROUGHTERRAIN_DISTANCE = 13; //Feet
	public static final double CROSS_ROUGHTERRAIN_VELOCITY = 3.0; //Feet per second
	public static final double CROSS_ROUGHTERRAIN_ACCEL_LIMIT = 3.0; // Feet per second squared

	public static final double CROSS_RAMPARTS_DISTANCE = 16.0; //Feet
	public static final double CROSS_RAMPARTS_VELOCITY = 7.0; //Feet per second
	public static final double CROSS_RAMPARTS_ACCEL_LIMIT = 5.0; // Feet per second squared
	public static final double CROSS_RAMPARTS_GYRO_PROPORTIONALITY = -0.05;
	
	public static final double CROSS_MOAT_DISTANCE = 16.0; // Feet
	public static final double CROSS_MOAT_VELOCITY = 8.0; //Feet per second
	public static final double CROSS_MOAT_ACCEL_LIMIT = 6.0; // Feet per second squared
	
	/*---------------------------------------Defense Alignment Positions----------------*/
	
	//Defense 2
	public static final double DEFENSE_ALIGNMENT2_ANGLE = 190.0;
	public static final double DEFENSE_ALIGNMENT2_DISTANCE = -4.0;
	public static final boolean DEFENSE_ALIGNMENT2_TURN = false;
	public static final boolean DEFENSE_ALIGNMENT2_ULTRA = false;
	
	//Defense 3
	public static final double DEFENSE_ALIGNMENT3_ANGLE = 150.0;
	public static final double DEFENSE_ALIGNMENT3_DISTANCE = -6.0;
	public static final boolean DEFENSE_ALIGNMENT3_TURN = false;
	public static final boolean DEFENSE_ALIGNMENT3_ULTRA = false;
	
	//Defense 4
	public static final double DEFENSE_ALIGNMENT4_ANGLE = 235.0;
	public static final double DEFENSE_ALIGNMENT4_DISTANCE = -7.5;
	public static final boolean DEFENSE_ALIGNMENT4_TURN = true;
	public static final boolean DEFENSE_ALIGNMENT4_ULTRA = false;
	
	//Defense 5
	public static final double DEFENSE_ALIGNMENT5_ANGLE = 190.0;
	public static final double DEFENSE_ALIGNMENT5_DISTANCE = -5.0;
	public static final boolean DEFENSE_ALIGNMENT5_TURN = true;
	public static final boolean DEFENSE_ALIGNMENT5_ULTRA = false;
	
	//Finishing Routine
	public static final double RIGHT_LOW_GOAL_ANGLE = -60;
	public static final double LEFT_LOW_GOAL_ANGLE = 60;
	
	/*---------------------------------------Intake-------------------------------------*/
	
	public static final double INTAKE_SPEED = 1.0; // Throttle value; full speed in
	public static final double EJECT_SPEED = -1.0; // Throttle value; full speed out
	public static final double HOLD_SPEED = 0.00; // Throttle value; not moving
	public static final double INTAKE_STICTION = 0.06; //Full battery
	public static final double INTAKE_SPEED_CURVE = 1; // Unitless exponent
	public static final double INTAKE_RELEASE_TIMEOUT = 1.25; // in seconds
	public static final double INTAKE_RELEASE_SPEED = 0.5; // in throttle
	
	/*---------------------------------------Scissor Lift--------------------------------*/
	
	public static final double SCISSOR_SAFE_FULL_SPEED_TIME = 0.1; // In seconds, the time it takes to achieve full speed
	public static final int SCALE_TIME_LIMIT = 20; //in seconds, how long we have to use the scissor lift each match end
	
	/*----------------------------------Auto Intake Constants----------------------------*/
	
	public static final int AUTO_INTAKE_TIMEOUT = 5;
	public static final double AUTO_INTAKE_FAR_DIST = .75;
	public static final double AUTO_INTAKE_CLOSE_DIST = .35;
	public static final double AUTO_INTAKE_FAST_SPEED = .75;
	public static final double AUTO_INTAKE_SLOW_SPEED = .35;
	
	/*----------------------------------Plop Boulder Constants----------------------------*/
	
	public static final double PLOP_BOULDER_TIMEOUT = 2.0;
	public static final double PLOP_BOULDER_FAR_DIST = 0.75;
	public static final double PLOP_BOULDER_CLOSE_DIST = 0.25;
	public static final double PLOP_BOULDER_FAST_SPEED = 0.75;
	public static final double PLOP_BOULDER_SLOW_SPEED = 0.35;
	
	/*-----------------------------------Sensor Constants-------------------------------*/
	
	public static final double MAX_ULTRA_CONVERSION = 92.0;
	
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
	public static int variable7 = 0;
	
	public static void displaySmartDashboard() {
		
		SmartDashboard.putNumber("Variable 1: ", 0.0);
		SmartDashboard.putNumber("Variable 2: ", 0.0);
		SmartDashboard.putNumber("Variable 3: ", 0.0);
		SmartDashboard.putNumber("Variable 4: ", 0.0);
		SmartDashboard.putNumber("Variable 5: ", 0.0);
		SmartDashboard.putBoolean("Variable 6: ", true);
		SmartDashboard.putNumber("Variable 7: ", 0);
	}
	
	public static void updateVariables() {
		
		variable1 = SmartDashboard.getNumber("Variable 1: ");
		variable2 = SmartDashboard.getNumber("Variable 2: ");
		variable3 = SmartDashboard.getNumber("Variable 3: ");
		variable4 = SmartDashboard.getNumber("Variable 4: ");
		variable5 = SmartDashboard.getNumber("Variable 5: ");
		variable6 = SmartDashboard.getBoolean("Variable 6: ");
		variable7 = SmartDashboard.getInt("Variable 7: ");
	}
}
