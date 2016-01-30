package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.*;

/**
 * @author Liam
 * This Class is used to handle all printouts from the roboRIO. To be able to graph information in excel we enter printouts in CSV format. We then select all and copy and paste that data into a text document and save it as a CSV file. You can then open it in excel and make a graph.
 */
public class RioLoggingCommand extends CommandBase {

	/**
	 * @author Liam
	 */
    public RioLoggingCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
	/**
	 * @author Liam
	 */
    protected void initialize() {
    	
    	// Add titles for data here
    	System.out.println("Data Title Goes Here,");
    	
    }

    // Called repeatedly when this Command is scheduled to run
	/**
	 * @author Liam
	 */
    protected void execute() {
    	
    	//Add printouts in CSV format for data here and remember to add a title above
    	System.out.println(",");
    }

    // Make this return true when this Command no longer needs to run execute()
	/**
	 * @author Liam
	 */
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
	/**
	 * @author Liam
	 */
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
	/**
	 * @author Liam
	 */
    protected void interrupted() {
    }
}
