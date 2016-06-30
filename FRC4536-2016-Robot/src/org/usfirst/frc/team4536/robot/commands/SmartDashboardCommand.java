package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4536.robot.TurningTrapezoidProfile;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;

public class SmartDashboardCommand extends CommandBase {
	
	//TurningTrapezoidProfile turnProfile;
	//TurnTrapezoidProfile turnTrapezoid;
	BraceAgainstWall braceAgainstWall = new BraceAgainstWall(Constants.variable1, Constants.variable2, Constants.variable3,
																Constants.DEFAULT_CROSSING_GYRO_PROPORTIONALITY, driveTrain.getAngle(),
																Constants.variable4);
	
	public SmartDashboardCommand() {
		
	}
	
	protected void initialize() {
		
		//turnTrapezoid = new TurnTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3);
		BraceAgainstWall braceAgainstWall = new BraceAgainstWall(Constants.variable1, Constants.variable2, Constants.variable3,
				Constants.DEFAULT_CROSSING_GYRO_PROPORTIONALITY, driveTrain.getAngle(),
				Constants.variable4);
		
		/*-----Commands to Run-----*/
		SmartDashboard.putData(braceAgainstWall);
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
		SmartDashboard.putNumber("Turn Rate in Degrees per Second: ", driveTrain.getYawRate());
		//SmartDashboard.putNumber("range", maxUltra.getRange());
		SmartDashboard.putNumber("Offset: ", driveTrain.getOffset());
		SmartDashboard.putNumber("Ball Distance: ", intake.getdistance());
		
		/*-----Display NavX Values-----*/
		
		SmartDashboard.putNumber("Yaw: ", driveTrain.getNavXYaw());
    	SmartDashboard.putNumber("Pitch: ", driveTrain.getNavXRoll()); // This depends on the orientation of the RoboRIO
    	SmartDashboard.putNumber("Roll: ", driveTrain.getNavXPitch()); // This depends on the orientation of the RoboRIO
    	SmartDashboard.putNumber("Field Centric Angle: ", driveTrain.getAngle());
    	SmartDashboard.putNumber("JerkX: ", driveTrain.getJerkX());
    	SmartDashboard.putNumber("JerkY: ", driveTrain.getJerkY());
    	SmartDashboard.putNumber("JerkZ: ", driveTrain.getJerkZ());
    	SmartDashboard.putNumber("Orthogonal Jerk: ", driveTrain.getOrthoganalJerk());
    	SmartDashboard.putBoolean("Collision: ", (driveTrain.getJerkX() > Constants.variable4 || driveTrain.getJerkY() > Constants.variable4)? true : false);

		/*-----Running Commands on Subsystems-----*/
		
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(intake);
		SmartDashboard.putData(scissorLift);
		
		/*-----Test Outputs-----*/
		
		SmartDashboard.putNumber("Test Output 1: ", 0);
		SmartDashboard.putNumber("Test Output 2: ", 0);
		SmartDashboard.putNumber("Test Output 3: ", 0);
		SmartDashboard.putNumber("Test Output 4: ", 0.0);
		SmartDashboard.putNumber("Test Output 5: ", 0.0);
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
