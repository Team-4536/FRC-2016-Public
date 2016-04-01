package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@author Liam
 */
public class WheelieStomp extends CommandGroup {
    
    public  WheelieStomp() {

    	addSequential(new DriveRectangleProfile(-Constants.variable1, 15));
    	addSequential(new DriveRectangleProfile(Constants.variable2, 15));
    }
}
