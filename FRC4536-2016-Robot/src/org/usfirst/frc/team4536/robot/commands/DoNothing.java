package org.usfirst.frc.team4536.robot.commands;

/**
 * @author Noah
 * This Command does nothing, it's for safety and auto modes
 */
public final class DoNothing extends CommandBase {

    public DoNothing() {
    	
    	requires(driveTrain);
    	requires(intake);
    	requires(scissorLift);
    }
    
    protected void initialize() {
    	
    	driveTrain.resetAccelValues();
    	intake.resetAccelValues();
    }
    
    protected void execute() {
    	
    	driveTrain.arcadeDriveAccelLimit(0.0, 0.0);
    	intake.setThrottleAccelLimited(0.0);
    	scissorLift.safeDrive(0.0);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
