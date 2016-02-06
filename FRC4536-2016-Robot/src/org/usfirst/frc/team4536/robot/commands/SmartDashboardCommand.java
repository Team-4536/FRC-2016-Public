package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardCommand extends CommandBase {
	
	public static double number;
	
	public SmartDashboardCommand() {
	
		requires(driveTrain);
		
	}
	
	protected void initialize() {
		
		/*-----Display Smart Dashboard Variables For Modifying and Accessing-----*/
		/* You must first display the value with a default value
		 * to change and access it later
		 */
		SmartDashboard.putNumber("Number: ", 0);
	
		
    }
	
    protected void execute() {
    	
    	
    	/*-----Access Values-----*/
    	/*@author Liam
    	 * If you have displayed a number on the SmartDashboard you may
    	 * change it and access its value.
    	 */
    	
    	number = SmartDashboard.getNumber("Number: ");
		
		/*-----Display Values-----*/
		
		SmartDashboard.putNumber("Main Joystick Y: ", OI.mainStick.getY());
		SmartDashboard.putNumber("Main Joystick X: ", OI.mainStick.getX());
		SmartDashboard.putNumber("Secondary Joystick Y: ", OI.secondaryStick.getY());
		SmartDashboard.putNumber("Secondary Joystick X: ", OI.secondaryStick.getX());
		SmartDashboard.putNumber("Voltage: ", Utilities.getVoltage());
		SmartDashboard.putNumber("Total Current: ", Utilities.getTotalCurrent());
		SmartDashboard.putNumber("Drive Train Left Encoder: ", driveTrain.getLeftEncoder());
		SmartDashboard.putNumber("Drive Train Right Encoder: ", driveTrain.getRightEncoder());
		SmartDashboard.putNumber("Drive Train Right Rate: ", driveTrain.getRightRate());
		SmartDashboard.putNumber("Drive Train Left Rate: ", driveTrain.getLeftRate());
		
		/*-----Display NavX Values-----*/
		
		SmartDashboard.putNumber("Yaw: ", driveTrain.getNavXYaw());
    		SmartDashboard.putNumber("Pitch: ", driveTrain.getNavXPitch());
    		SmartDashboard.putNumber("Roll: ", driveTrain.getNavXRoll());
		
		/*-----Running Commands on Subsystems-----*/
		
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(intake);
		SmartDashboard.putData(piston);
		SmartDashboard.putData(compressorSubsystem);
    }
    
    /**
	 * @author Jeremy
	 * @return Whether the command is safe to be finished (true if it can be finished)
	 */
    protected boolean isFinished() {
        return false;
    }
    
    /**
	 * @author Jeremy
	 */
    protected void end() {
    	
    }
    
    /**
	 * @author Jeremy
	 */
    protected void interrupted() {
    	end();
    }

}
