package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;

public class SmartDashboardCommand extends CommandBase {
	
	TrapezoidProfile trapezoid;
	DriveTrapezoidProfile driveTrapezoid;
	
	public SmartDashboardCommand() {
		
	}
	
	
	protected void initialize() {
		
		driveTrapezoid = new DriveTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3);
	
		/*-----Commands to Run-----*/
		SmartDashboard.putData(new DriveTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3));
		trapezoid = new TrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3);
    }
	
    protected void execute() {
		
		/*-----Display Values-----*/
		
    	SmartDashboard.putNumber("Time: ", Utilities.getTime());
		SmartDashboard.putNumber("Main Joystick Y: ", OI.mainStick.getY());
		SmartDashboard.putNumber("Main Joystick X: ", OI.mainStick.getX());
		SmartDashboard.putNumber("Secondary Joystick Y: ", OI.secondaryStick.getY());
		SmartDashboard.putNumber("Secondary Joystick X: ", OI.secondaryStick.getX());
		SmartDashboard.putNumber("Voltage: ", Utilities.getVoltage());
		SmartDashboard.putNumber("Total Current: ", Utilities.getTotalCurrent());
		SmartDashboard.putNumber("Drive Train Left Encoder: ", driveTrain.getLeftEncoder());
		SmartDashboard.putNumber("Drive Train Right Encoder: ", driveTrain.getRightEncoder());
		SmartDashboard.putNumber("Drive Train Right Rate: ", driveTrain.getRightRate());
		SmartDashboard.putNumber("Drive Train Left Rate: ", driveTrain.getLeftRate());
		SmartDashboard.putNumber("Previous Forward Throttle", driveTrain.oldForwardThrottle);
		SmartDashboard.putNumber("Turn Rate in Degrees per Second: ", driveTrain.getYawRate());
		SmartDashboard.putNumber("Back ultra Value", driveTrain.getBackDist());
		SmartDashboard.putNumber("Intake IR Value", intake.getdistance());
		
		SmartDashboard.putNumber("get back dist", GetBackDistance.dist);
		SmartDashboard.putNumber("Back ultra basic value", driveTrain.updateBackDist());
		
		/*-----Display NavX Values-----*/
		
		SmartDashboard.putNumber("Yaw: ", driveTrain.getNavXYaw());
    	SmartDashboard.putNumber("Pitch: ", driveTrain.getNavXPitch());
    	SmartDashboard.putNumber("Roll: ", driveTrain.getNavXRoll());
		
		/*-----Running Commands on Subsystems-----*/
		
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(intake);
		SmartDashboard.putData(scissorLift);
		
		/*-----Test Outputs-----*/
		
		SmartDashboard.putNumber("Test Output 1: ", 0);
		SmartDashboard.putNumber("Test Output 2: ", 0);
		SmartDashboard.putNumber("Test Output 3: ", trapezoid.getTimeNeeded());
		SmartDashboard.putNumber("Test Output 4: ", 0.0);
		SmartDashboard.putNumber("Test Output 5: ", 0.0);
		SmartDashboard.putNumber("Test Output 6: ", trapezoid.idealVelocity(Utilities.getTime()-5));
		SmartDashboard.putNumber("Test Output 7: ", trapezoid.idealDistance(Utilities.getTime()-5));
		SmartDashboard.putNumber("Test Output 8: ", trapezoid.getTimeNeeded());
		SmartDashboard.putNumber("Test Output 9: ", trapezoid.throttle(Utilities.getTime() - 5));
		
		if (trapezoid.isTriangle()) {
			
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
