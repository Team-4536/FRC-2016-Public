package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Noah
 * This Class is used to handle all printouts from the roboRIO. To be able to graph information in excel we enter printouts in CSV format. We then select all and copy and paste that data into a text document and save it as a CSV file. You can then open it in excel and make a graph.
 */
public class RioLoggingCommand extends CommandBase {
	
    public RioLoggingCommand() {
    }
    
    protected void initialize() {
    	
    	// Add titles for data here
    	System.out.println("Data Title Goes Here,");
    	
    }
    
    protected void execute() {
    	
    	//Add printouts in CSV format for data here and remember to add a title above
    	System.out.println(",");
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
