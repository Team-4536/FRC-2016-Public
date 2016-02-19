package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

/**
 *
 */
public class DriveScissorLift extends CommandBase {

    public DriveScissorLift(){
    	requires(scissorLift);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	scissorLift.driveLift(OI.tertiaryStick.getY());
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}