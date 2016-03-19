package org.usfirst.frc.team4536.robot.commands;

public class GetBackDistance extends CommandBase {
	
	static double dist = 5;
	
	public GetBackDistance() {
		requires(driveTrain);
	}
	
	public void initialize() {
		dist = driveTrain.getBackDist();
		setTimeout(.2);
	}
	
	protected void execute() {
		dist = driveTrain.getBackDist();
    }
	
    protected boolean isFinished() {
        return isTimedOut();
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
    
    public double returnDistance() {
    	//System.out.println("running" + dist);
    	return dist;
    }
	
}
