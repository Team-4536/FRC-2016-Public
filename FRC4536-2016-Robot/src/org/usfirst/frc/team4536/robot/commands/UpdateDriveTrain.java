package org.usfirst.frc.team4536.robot.commands;

/**
 *
 */
public class UpdateDriveTrain extends CommandBase {

    public UpdateDriveTrain() {
    	requires(driveTrain);
    	setTimeout(.2);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	driveTrain.update();
    }
    
    protected boolean isFinished() {
        return isTimedOut();
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
