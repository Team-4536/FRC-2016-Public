
package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4536.robot.Constants;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.subsystems.ElectricalSolenoid;
import org.usfirst.frc.team4536.robot.subsystems.Piston;
import org.usfirst.frc.team4536.robot.subsystems.ScissorLift;
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
    Command startIntakeRelay;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		//oi = new OI(); 
        // instantiate the command used for the autonomous period
        driveTrainCommand = new DriveTrainCommand();
        runCompressor = new RunCompressor();
        autoChooser = new AutoChooser();
        pistonFlipCommand = new PistonFlipCommand();
        driveIntake = new DriveIntakeArm();
        intakeAccelLimited = new DriveIntakeAccelLimited(); //TODO work on this name...
        smartDashboardCommand = new SmartDashboardCommand();
        driveScissorLift = new DriveScissorLift();
        driveAccelLimited = new DriveAccelLimited();
        flipRelay = new FlipScissorRelay();
        safeDriveScissorLift = new SafeDriveScissorLift();
        OI.buttonHandling();
        startIntakeRelay = new StartIntakeRelay();
        
        
        Constants.displaySmartDashboard();
        
        //pistonFlipCommand = new PistonFlipCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        
        CommandBase.driveTrain.resetNavX();
        
        CommandBase.driveTrain.resetRightEncoder();
    	
        // schedule the autonomous command (example)
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

		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
    	CommandBase.driveTrain.resetNavX();
    	
    	CommandBase.driveTrain.resetRightEncoder();
    	
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
        
        if (safeDriveScissorLift != null) {
        	
        	safeDriveScissorLift.start();
        }
        
        Utilities.startTimer();
        
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
        if (smartDashboardCommand != null) {
        	
        	smartDashboardCommand.start();
        }
        
        //runUltraCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
        Scheduler.getInstance().run();
        Utilities.updateCycleTime();
        Constants.updateVariables();
        
        //runUltraCommand.start();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
        LiveWindow.run();
    }
}
