package org.usfirst.frc.team4536.robot.commands;

public class RunUltra extends CommandBase {
	
	public RunUltra() {
		requires(maxUltra);
    }
	
    protected void initialize() {
    }
    
    protected void execute() {
    	System.out.println(maxUltra.getRange());
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
	
}
