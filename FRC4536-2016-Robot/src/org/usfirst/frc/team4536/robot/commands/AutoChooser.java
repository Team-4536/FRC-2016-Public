package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *@author Liam
 *This chooses the autonomous mode which will be executed for the duration of the match.
 */
public class AutoChooser extends CommandBase {
	
	SendableChooser autoChooser;
	DoNothing doNothing;
	ReachOuterWorks reachOuterWorks;

    public AutoChooser() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	/*-----Constructors-----*/
    	
    	autoChooser = new SendableChooser();
    	
    	/*-----AutonomousModes-----*/
    	
    	doNothing = new DoNothing();
    	reachOuterWorks = new ReachOuterWorks();
    	
    	/*-----Selectable Chooser Options----*/
    	
    	autoChooser.addDefault("DoNothing", 0);
    	autoChooser.addObject("Breach Outer Works",  1);
    	SmartDashboard.putData("Auto Chooser", autoChooser);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	System.out.println("Auto Number: " + (int) autoChooser.getSelected().hashCode());
    	
    	switch ((int) autoChooser.getSelected().hashCode()) {
    	
    		case 0:
    			
    			doNothing.start();
    			
    			System.out.println(0);
    			
    		case 1:
    			System.out.println(1);
    			reachOuterWorks.start();
    	
    		default: 
    			
    			System.out.println("Default");
    			driveTrain.arcadeDrive(0.0, 0.0);
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
