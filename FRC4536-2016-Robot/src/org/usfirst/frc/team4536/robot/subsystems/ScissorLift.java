package org.usfirst.frc.team4536.robot.subsystems;
import org.usfirst.frc.team4536.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author Liam
 *
 */
public class ScissorLift extends Subsystem {
	
	VictorSP scissorLift;
	Relay relay;
	
		public ScissorLift(int motorChannel){
	
			scissorLift = new VictorSP(motorChannel);
			relay = new Relay(RobotMap.RELAY_CHANNEL, Relay.Direction.kForward);
			
		}
		
		/**
		 * @author Liam
		 * @param Throttle the value [-1, 1] sent to the motor. Negative values make it climb.
		 * Positive values make it go down.
		 */
		public void driveLift(double Throttle) {
			scissorLift.set(Throttle);
			
	    }
		
		public void relayOn() {
			relay.set(Relay.Value.kOn);
		}
		public void relayOff() {
			relay.set(Relay.Value.kOff);
		}
		public void relayFlip() {
			if (relay.get() == Relay.Value.kOn){
				relayOn();
			} else {
				relayOff();
			}
		}
			
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}