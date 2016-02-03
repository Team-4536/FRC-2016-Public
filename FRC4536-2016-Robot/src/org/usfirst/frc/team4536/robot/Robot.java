
package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4536.robot.commands.*;
import org.usfirst.frc.team4536.robot.subsystems.Piston;
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

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        driveTrainCommand = new DriveTrainCommand();
        runCompressor = new RunCompressor();
        autoChooser = new AutoChooser();
        //pistonFlipCommand = new PistonFlipCommand();
        driveIntake = new DriveIntakeArm();
        OI.buttonHandling();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	
    	System.out.println("Autonomus Init");
    	
        // schedule the autonomous command (example)
        if (autoChooser != null) {
        	
        	autoChooser.start();
        	
        	System.out.println("Auto Chooser Entered");
        }
        
        Utilities.startTimer();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        Utilities.updateCycleTime();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (driveTrainCommand != null) {
        	
        	driveTrainCommand.start();
        }
        
        Utilities.startTimer();
        
        if (driveIntake != null) {
        	
        	driveIntake.start();
        }
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
        Scheduler.getInstance().run();
        Utilities.updateCycleTime();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
        LiveWindow.run();
    }
}
