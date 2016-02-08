package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team4536.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
	/*----------------Initializations------------------*/
	
	//Joysticks
	public static Joystick mainStick = new Joystick(RobotMap.MAIN_STICK);
	public static Joystick secondaryStick = new Joystick(RobotMap.SECONDARY_STICK);
	public static Joystick tertiaryStick = new Joystick(RobotMap.TERTIARY_STICK);
	
	//Buttons
	public static Button intake; 
	public static Button eject;
	public static Button hold;
	public static Button tangleTest;
	
	/**
	 * @author Liam
	 * This instantiates Button handling.
	 */
	public static void buttonHandling () {
		
		intake = new JoystickButton(secondaryStick, 5);
		eject = new JoystickButton(secondaryStick, 6);
		hold = new JoystickButton(secondaryStick, 7);
		tangleTest = new JoystickButton(mainStick, 11);
		
		
		/*-------------------Actions------------------------*/
		
		intake.whenPressed(new IntakeBall());
		eject.whenPressed(new EjectBall());
		hold.whenPressed(new HoldBall());
		tangleTest.whenPressed(new DriveRectangleProfile(-2,1));
		
		/*------------------Canceling actions--------------*/
		
		intake.whenReleased(new DriveIntakeArm());
		eject.whenReleased(new DriveIntakeArm());
		hold.whenReleased(new DriveIntakeArm());
	}
}

////CREATING BUTTONS
// One type of button is a joystick button which is any button on a joystick.
// You create one by telling it which joystick it's on and which button
// number it is.
// Joystick stick = new Joystick(port);
// Button button = new JoystickButton(stick, buttonNumber);

// There are a few additional built in buttons you can use. Additionally,
// by subclassing Button you can create custom triggers and bind those to
// commands the same as any other Button.

//// TRIGGERING COMMANDS WITH BUTTONS
// Once you have a button, it's trivial to bind it to a button in one of
// three ways:

// Start the command when the button is pressed and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenPressed(new ExampleCommand());

// Run the command while the button is being held down and interrupt it once
// the button is released.
// button.whileHeld(new ExampleCommand());

// Start the command when the button is released  and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenReleased(new ExampleCommand());

