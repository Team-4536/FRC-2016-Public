package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardCommand extends CommandBase {
	
	/**
	 * @author Jeremy
	 */
	public SmartDashboardCommand() {}
	
	/**
	 * @author Jeremy
	 */
	protected void initialize() {
		
    }
	
	/**
	 * @author Jeremy
	 */
    protected void execute() {
    	
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