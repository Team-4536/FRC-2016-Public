package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardCommand extends CommandBase {
	
	public static double number;
	
	/**
	 * @author Jeremy
	 */
	public SmartDashboardCommand() {}
	
	/**
	 * @author Jeremy
	 */
	protected void initialize() {
		
		/*-----Display Smart Dashboard Variables For Modifying and Accessing-----*/
		/* You must first display the value with a default value
		 * to change and access it later
		 */
		SmartDashboard.putNumber("Number: ", 0);
		
    }
	
	/**
	 * @author Jeremy
	 */
    protected void execute() {
    	
    	/*-----Access Values-----*/
    	/*@author Liam
    	 * If you have displayed a number on the SmartDashboard you may
    	 * change it and access its value.
    	 */
    	number = SmartDashboard.getNumber("Number: ");
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