package org.usfirst.frc.team4536.robot.subsystems;
import org.usfirst.frc.team4536.robot.Utilities;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author Liam
 *
 */
public class ScissorLift extends Subsystem {
	
	VictorSP scissorLift;
	
		public ScissorLift(int motorChannel){
	
			scissorLift = new VictorSP(motorChannel);
				
		}
		
		/**
		 * @author Liam
		 * @param Throttle the value [-1, 1] sent to the motor. Negative values make it climb.
		 * Positive values make it go down.
		 */
		public void driveLift(double throttle) {
			scissorLift.set(throttle);
			
	    }
		public void safeDrive(double throttle) {
			driveLift(Utilities.limit(throttle, -1.0, 0.0));
		}
			
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}