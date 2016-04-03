package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 */
public class WheelieStomp extends CommandGroup {
	
	DriveTrapezoidProfile trap1;
	DriveTrapezoidProfile trap2;
	DriveTrapezoidProfile trap3;
	DriveTrapezoidProfile trap4;

    public  WheelieStomp() {
    	
    	trap1 = new DriveTrapezoidProfile(Constants.variable1, Constants.variable2, Constants.variable3);
    	trap2 = new DriveTrapezoidProfile(Constants.variable4, Constants.variable5, Constants.variable8);
    	trap3 = new DriveTrapezoidProfile(Constants.variable9, Constants.variable10, Constants.variable11);
    	trap4 = new DriveTrapezoidProfile(Constants.variable12, Constants.variable13, Constants.variable14);

    	addSequential(trap1, trap1.getNeededTime());
    	addSequential(trap2, trap2.getNeededTime());
    	addSequential(trap3, trap3.getNeededTime());
    	addSequential(trap4, trap4.getNeededTime());
    }
}
