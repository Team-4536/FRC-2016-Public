package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.RectangleProfileForTurning;
import edu.wpi.first.wpilibj.Timer;

public class TurnTo extends CommandBase {
	
	double desiredAngle;
	double currentAngle;
	double difference;
	double time;
	double throttle;
	
	Timer timer = new Timer();
	RectangleProfileForTurning rectangle;
	
    public TurnTo(double desiredAngle, double velocity) {
    	
    	requires(driveTrain);
    	
    	this.desiredAngle = desiredAngle;
    	currentAngle = driveTrain.getNavXYaw();
    	difference = Utilities.angleDifference(currentAngle, desiredAngle);
    	rectangle = new RectangleProfileForTurning(difference, velocity);
    	
    }
    
    protected void initialize() {
    	timer.reset();
    	timer.start();
    }
    
    protected void execute() {
    	time = timer.get();
    	
    	throttle = rectangle.getThrottle(time) - 0.009*(Utilities.angleDifference(rectangle.getIdealAngle(time), driveTrain.getNavXYaw()));
    	
    	driveTrain.arcadeDrive(0, throttle);
    	
    }
    
    protected boolean isFinished() {
    	if(((driveTrain.getNavXYaw() - desiredAngle) < 1) 
    		&& driveTrain.getYawRate() < 1){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
