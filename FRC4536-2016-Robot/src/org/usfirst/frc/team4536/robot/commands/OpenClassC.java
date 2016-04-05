package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenClassC extends CommandGroup {
	
    public  OpenClassC(boolean orientation, double defensesOver) {
        
    	DriveTrapezoidProfile crossDefense;
    	TeleopTurn turnOne;
    	DriveTrapezoidProfile moveOver;
    	TeleopTurn turnTwo;
    	DriveTrapezoidProfile crossClassC;
    	
    	if (orientation){
    		
    		if (defensesOver > 0){
        		turnOne = new TeleopTurn(90);
        	}else{
        		turnOne = new TeleopTurn(270);
        	}
    		
    		addSequential(turnOne);
    		
    		moveOver = new DriveTrapezoidProfile(-Constants.DISTANCE_BETWEEN_DEFENSES*defensesOver);
    		addSequential(moveOver);
    		
    		turnTwo = new TeleopTurn(180);
    		addSequential(turnTwo);
    		
    		crossClassC = new DriveTrapezoidProfile(Constants.DISTANCE_BETWEEN_ALIGNMENT_LINE_AND_CLASSC);
    		addSequential(crossClassC);
    		
    	}else{
    		
    		if (defensesOver > 0){
        		turnOne = new TeleopTurn(-90);
        	}else{
        		turnOne = new TeleopTurn(-270);
        	}
    		
    		addSequential(turnOne);
    		
    		moveOver = new DriveTrapezoidProfile(-(Constants.DISTANCE_BETWEEN_DEFENSES*(Math.abs(defensesOver)-1) + Constants.DISTANCE_BETWEEN_DEFENSES/2));
    		addSequential(moveOver);
    		
    		turnTwo = new TeleopTurn(0);
    		addSequential(turnTwo);
    		
    		crossClassC = new DriveTrapezoidProfile(-Constants.DISTANCE_BETWEEN_ALIGNMENT_LINE_AND_CLASSC);
    		addSequential(crossClassC);
    	}
    	
    }
}
