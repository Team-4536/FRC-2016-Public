package org.usfirst.frc.team4536.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ScissorLift extends Subsystem {
	
	VictorSP scissorLift;
	
		public ScissorLift(int motorChannel){
	
			scissorLift = new VictorSP(motorChannel);
			
		}
		
		public void driveLift(double Throttle) {
			scissorLift.set(Throttle);
			
	    }
			
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}