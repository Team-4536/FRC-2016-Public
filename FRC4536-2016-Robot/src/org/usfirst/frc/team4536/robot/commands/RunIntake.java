package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.Command;

 class RunIntake extends CommandBase {

    public RunIntake(double throttle, double accel) {
    	
    	intake.resetAccelValues();
    	
    	setTimeout(10);

    	intake.setThrottleAccelLimited(throttle, accel);

        while (isTimedOut() == true){
        	
        	intake.resetAccelValues();
        	intake.setThrottleAccelLimited(0.0);
        	
        }
    }
}

