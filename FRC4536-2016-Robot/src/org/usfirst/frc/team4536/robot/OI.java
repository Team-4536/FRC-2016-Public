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
	public static Button autoIntake;
	public static Button turnTest;
	public static Button deployScissors;
	
	/**
	 * @author Liam
	 * This instantiates Button handling.
	 */
	public static void buttonHandling () {
		
		intake = new JoystickButton(secondaryStick, 5);
		eject = new JoystickButton(secondaryStick, 6);
		hold = new JoystickButton(secondaryStick, 7);
		autoIntake = new JoystickButton(secondaryStick, 8);
		
		turnTest = new JoystickButton(mainStick, 12);
		deployScissors = new JoystickButton(tertiaryStick, 1);
		
		/*-------------------Actions------------------------*/

		intake.whenPressed(new IntakeBoulderAccelLimited());
		eject.whenPressed(new EjectBoulderAccelLimited());
		hold.whenPressed(new HoldBoulderAccelLimited());
		autoIntake.whenPressed(new AutoIntake());
		
		turnTest.whenPressed(new TurnTo( 90, 30));
		deployScissors.whenPressed(new StartScissorRelay());
		
		/*------------------Canceling actions--------------*/
		
		intake.whenReleased(new DriveIntakeAccelLimited());
		eject.whenReleased(new DriveIntakeAccelLimited());
		hold.whenReleased(new DriveIntakeAccelLimited());
		deployScissors.whenReleased(new StopScissorRelay());
	}
}
