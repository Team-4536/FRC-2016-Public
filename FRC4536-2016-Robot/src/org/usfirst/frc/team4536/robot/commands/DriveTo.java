package org.usfirst.frc.team4536.robot.commands;

/**
 *
 */
public class DriveTo extends CommandBase {
	
	DriveTrapezoidProfile driveTrap;
	double dist;
	
    public DriveTo() {
    	requires(driveTrain);
    }
    
    protected void initialize() {
    	dist = driveTrain.getBackDist() - 3;
    	driveTrap = new DriveTrapezoidProfile(-dist, 3, 3);
    	driveTrap.start();
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
