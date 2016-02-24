package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;

/**
 *@author Sheila
 */
public class SuperSafeDriveScissorLift extends CommandBase {

 private boolean manualOverride;
 
    public SuperSafeDriveScissorLift(){
     
        requires(scissorLift);
        manualOverride = false;
    }
    
    protected void initialize() {
     
     scissorLift.resetValues();
    }
    
    protected void execute() {
     
  //overrides the timer limit ^
  if (OI.tertiaryStick.getRawButton(2) && OI.tertiaryStick.getRawButton(3)) {
   manualOverride = true;
  }

  //The teleop time (120 seconds) minus the time we have available to scale
  //this keeps us from violating the rules about extending before the end
  if((Utilities.getTime()>135-Constants.SCALE_TIME_LIMIT) || manualOverride) {
   scissorLift.safeDrive(Utilities.deadZone(OI.tertiaryStick.getY(), Constants.SCISSOR_DEAD_ZONE));
  } else {
   System.out.println("Hey! The match is still going! No climbing yet!");
  }
 }
    
    protected boolean isFinished() {
     
        return false;
    }
    
    protected void end() {
     
    }
    
    protected void interrupted() {
     
     
    }
}
