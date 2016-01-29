package org.usfirst.frc.team4536.robot.commands;

/**
 * @ author Kool Guy Donald Trump
 */
//if the compressor is run it needs "CompressorSubsystem"
public class RunCompressor extends Commandbase {

    public RunCompressor() {
    	requires(compressorSubsystem);
        // Use requires() here to declare subsystem dependencies
 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	compressorSubsystem.startComp();
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
    	compressorSubsystem.stopComp();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
     compressorSubsystem.stopComp();
    }
}
