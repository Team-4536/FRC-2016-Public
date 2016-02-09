package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.OI;
import org.usfirst.frc.team4536.robot.Utilities;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4536.robot.TrapezoidProfile;

public class SmartDashboardCommand extends CommandBase {
	
	TrapezoidProfile trapezoid;
	
	public SmartDashboardCommand() {
		
		
	}
	
	protected void initialize() {
	
		/*-----Commands to Run-----*/
		
		SmartDashboard.putData(new IntakeBall());
		SmartDashboard.putData(new EjectBall());
		SmartDashboard.putData(new HoldBall());
		SmartDashboard.putData(new DriveTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3));
		trapezoid = new TrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3);
    }
	
    protected void execute() {
		
		/*-----Display Values-----*/
		
		SmartDashboard.putNumber("Main Joystick Y: ", OI.mainStick.getY());
		SmartDashboard.putNumber("Main Joystick X: ", OI.mainStick.getX());
		SmartDashboard.putNumber("Secondary Joystick Y: ", OI.secondaryStick.getY());
		SmartDashboard.putNumber("Secondary Joystick X: ", OI.secondaryStick.getX());
		SmartDashboard.putNumber("Voltage: ", Utilities.getVoltage());
		//SmartDashboard.putNumber("Total Current: ", Utilities.getTotalCurrent());
		SmartDashboard.putNumber("Drive Train Left Encoder: ", driveTrain.getLeftEncoder());
		SmartDashboard.putNumber("Drive Train Right Encoder: ", driveTrain.getRightEncoder());
		SmartDashboard.putNumber("Drive Train Right Rate: ", driveTrain.getRightRate());
		SmartDashboard.putNumber("Drive Train Left Rate: ", driveTrain.getLeftRate());
		
		/*-----Display NavX Values-----*/
		
		SmartDashboard.putNumber("Yaw: ", driveTrain.getNavXYaw());
    	SmartDashboard.putNumber("Pitch: ", driveTrain.getNavXPitch());
    	SmartDashboard.putNumber("Roll: ", driveTrain.getNavXRoll());
		
		/*-----Running Commands on Subsystems-----*/
		
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putData(intake);
		SmartDashboard.putData(compressorSubsystem);
		SmartDashboard.putData(scissorLift);
		
		/*-----Test Outputs-----*/
		
		SmartDashboard.putNumber("Test Output 1: ", trapezoid.idealVelocity(1));
		SmartDashboard.putNumber("Test Output 2: ", trapezoid.idealVelocity(2));
		SmartDashboard.putNumber("Test Output 3: ", trapezoid.timeNeeded);
		SmartDashboard.putNumber("Test Output 4: ", trapezoid.criticalDistance);
		SmartDashboard.putNumber("Test Output 5: ", trapezoid.criticalTime);
    }
    
    /**
	 * @author Jeremy
	 * @return Whether the command is safe to be finished (true if it can be finished)
	 */
    protected boolean isFinished() {
        return false;
    }
    
    /**
	 * @author Jeremy
	 */
    protected void end() {
    	
    }
    
    /**
	 * @author Jeremy
	 */
    protected void interrupted() {
    	end();
    }

}
