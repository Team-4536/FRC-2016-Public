
package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.commands.DriveIntakeArm;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command driveTrainCommand;
    Command runCompressor;
    Command pistonFlipCommand;
    Command autoChooser;
    Command driveIntake;
    Command smartDashboardCommand;
    Command driveScissorLift;
    Command driveAccelLimited;
    Command intakeAccelLimited;
    Command flipRelay;
    Command safeDriveScissorLift;
    Command superSafeDriveScissorLift;
    Command startIntakeRelay;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        driveTrainCommand = new DriveTrainCommand();
        driveIntake = new DriveIntakeArm();
        intakeAccelLimited = new DriveIntakeAccelLimited();
        smartDashboardCommand = new SmartDashboardCommand();
        driveAccelLimited = new DriveAccelLimited();
        safeDriveScissorLift = new SafeDriveScissorLift();
        superSafeDriveScissorLift = new SuperSafeDriveScissorLift();
        OI.buttonHandling();
        autoChooser = new AutoChooser();
        
        Constants.displaySmartDashboard();
        
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        
        CommandBase.driveTrain.resetEncoders();
        
        CommandBase.driveTrain.resetAccelValues();
        
        CommandBase.intake.resetAccelValues();

        autoChooser = new AutoChooser();
        if (autoChooser != null) {
        	
        	autoChooser.start();
        }
        
        if (smartDashboardCommand != null) {
        	
        	smartDashboardCommand.start();
        }

        if (startIntakeRelay != null) {
        	
        	startIntakeRelay.start();
        }
        
        Utilities.startTimer();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        Utilities.updateCycleTime();
        Constants.updateVariables();
    }

    public void teleopInit() {
    	
    	CommandBase.driveTrain.resetEncoders();
    	
    	CommandBase.driveTrain.resetAccelValues();
    	
    	CommandBase.intake.resetAccelValues();
    	
        if (flipRelay != null) {
        	
        	flipRelay.start();
        }
    	
    	
        if (driveAccelLimited != null) {
        	
        	driveAccelLimited.start();
        }
        
        if (smartDashboardCommand != null) {
        	
        	smartDashboardCommand.start();
        }
        
        if (intakeAccelLimited != null) {
        	
        	intakeAccelLimited.start();
        }
        
        if (superSafeDriveScissorLift != null) {
        	
        	superSafeDriveScissorLift.start();
        }
        
        Utilities.startTimer();
        
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    	CommandBase.driveTrain.resetAccelValues();
    	
        if (smartDashboardCommand != null) {
        	
        	smartDashboardCommand.start();
        }
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
        Scheduler.getInstance().run();
        Utilities.updateCycleTime();
        Constants.updateVariables();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
        LiveWindow.run();
    }
}
