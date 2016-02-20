package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;

public class SmartDashboardCommand extends CommandBase {
	
	TurningTrapezoidProfile turnProfile;
	TurnTrapezoidProfile turnTrapezoid;
	
	public SmartDashboardCommand() {
		
	}
	
	
	protected void initialize() {
		
		turnTrapezoid = new TurnTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3);
	
		/*-----Commands to Run-----*/
		SmartDashboard.putData(new TurnTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3));
		turnProfile = new TurningTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3);
    }
	
    protected void execute() {
		
		/*-----Display Values-----*/
		
    	SmartDashboard.putNumber("Time: ", Utilities.getTime());
		SmartDashboard.putNumber("Main Joystick Y: ", OI.mainStick.getY());
		SmartDashboard.putNumber("Main Joystick X: ", OI.mainStick.getX());
		SmartDashboard.putNumber("Secondary Joystick Y: ", OI.secondaryStick.getY());
		SmartDashboard.putNumber("Secondary Joystick X: ", OI.secondaryStick.getX());
		SmartDashboard.putNumber("Tertiary Joystick Y: ", OI.tertiaryStick.getY());
		SmartDashboard.putNumber("Tertiary Joystick X: ", OI.tertiaryStick.getX());
		//SmartDashboard.putNumber("Voltage: ", Utilities.getVoltage());
		//SmartDashboard.putNumber("Total Current: ", Utilities.getTotalCurrent());
		SmartDashboard.putNumber("Drive Train Left Encoder: ", driveTrain.getLeftEncoder());
		SmartDashboard.putNumber("Drive Train Right Encoder: ", driveTrain.getRightEncoder());
		SmartDashboard.putNumber("Drive Train Right Rate: ", driveTrain.getRightRate());
		SmartDashboard.putNumber("Drive Train Left Rate: ", driveTrain.getLeftRate());
		SmartDashboard.putNumber("Previous Forward Throttle", driveTrain.oldForwardThrottle);
		SmartDashboard.putNumber("Turn Rate in Degrees per Second: ", driveTrain.getYawRate());
		//SmartDashboard.putNumber("range", maxUltra.getRange());
		SmartDashboard.putNumber("Offset: ", driveTrain.getOffset());
		SmartDashboard.putNumber("Ball Distance: ", intake.getdistance());

		/*-----Display NavX Values-----*/
		
		SmartDashboard.putNumber("Yaw: ", driveTrain.getNavXYaw());
    	SmartDashboard.putNumber("Pitch: ", driveTrain.getNavXPitch());
    	SmartDashboard.putNumber("Roll: ", driveTrain.getNavXRoll());
    	SmartDashboard.putNumber("getAngle(): ", driveTrain.getAngle());
		
		/*-----Running Commands on Subsystems-----*/
		
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(intake);
		SmartDashboard.putData(scissorLift);
		
		/*-----Test Outputs-----*/
		
		SmartDashboard.putNumber("Test Output 1: ", 0);
		SmartDashboard.putNumber("Test Output 2: ", 0);
		SmartDashboard.putNumber("Test Output 3: ", turnProfile.timeNeeded());
		SmartDashboard.putNumber("Test Output 4: ", 0.0);
		SmartDashboard.putNumber("Test Output 5: ", 0.0);
		SmartDashboard.putNumber("Test Output 6: ", turnProfile.idealVelocity(Utilities.getTime()-5));
		SmartDashboard.putNumber("Test Output 7: ", turnProfile.idealDistance(Utilities.getTime()-5));
		SmartDashboard.putNumber("Test Output 8: ", turnProfile.timeNeeded());
		SmartDashboard.putNumber("Test Output 9: ", turnProfile.throttle(Utilities.getTime() - 5));
		
		if (turnProfile.isTriangle()) {
			
			SmartDashboard.putString("Triangle or Trapezoid: ", "Triangle");
		}
		else {
			
			SmartDashboard.putString("Triangle or Trapezoid: ", "Trapezoid");
		}
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    	
    }
    
    protected void interrupted() {
    	end();
    }

}
