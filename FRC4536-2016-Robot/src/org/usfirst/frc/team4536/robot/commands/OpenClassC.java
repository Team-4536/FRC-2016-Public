package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class OpenClassC extends CommandGroup {
	
    public  OpenClassC(double distance, double velocity, double accel, double extratime, double gyro, boolean orientation, double defensesOver) {
        
    	addParallel(new ReleaseIntake());
    	
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
    		
        	crossDefense = new DriveTrapezoidProfile(distance, velocity, accel);
        	double maxTime = crossDefense.getNeededTime() + extratime;
    		addSequential(crossDefense, maxTime);
    		
    		addSequential(turnOne);
    		
    		moveOver = new DriveTrapezoidProfile(Constants.DISTANCE_BETWEEN_DEFENSES*defensesOver, 
    				Constants.SPEED_LIMIT, Constants.ACCEL_LIMIT_DRIVE);
    		addSequential(moveOver);
    		
    		turnTwo = new TeleopTurn(180);
    		addSequential(turnTwo);
    		
    		crossClassC = new DriveTrapezoidProfile(Constants.DISTANCE_BETWEEN_ALIGNMENT_LINE_AND_CLASSC,
    				Constants.SPEED_LIMIT,Constants.ACCEL_LIMIT_DRIVE);
    		addSequential(crossClassC);
    		
    	}else{
    		
    		if (defensesOver > 0){
        		turnOne = new TeleopTurn(-90);
        	}else{
        		turnOne = new TeleopTurn(-270);
        	}
    		
        	crossDefense = new DriveTrapezoidProfile(-distance, velocity, accel);
        	double maxTime = crossDefense.getNeededTime() + extratime;
    		addSequential(crossDefense, maxTime);
    		
    		addSequential(turnOne);
    		
    		moveOver = new DriveTrapezoidProfile(-(Constants.DISTANCE_BETWEEN_DEFENSES*defensesOver),
    				Constants.SPEED_LIMIT, Constants.ACCEL_LIMIT_DRIVE);
    		addSequential(moveOver);
    		
    		turnTwo = new TeleopTurn(0);
    		addSequential(turnTwo);
    		
    		crossClassC = new DriveTrapezoidProfile(-Constants.DISTANCE_BETWEEN_ALIGNMENT_LINE_AND_CLASSC,
    				Constants.SPEED_LIMIT,Constants.ACCEL_LIMIT_DRIVE);
    		addSequential(crossClassC);
    	}
    	
    }
}
