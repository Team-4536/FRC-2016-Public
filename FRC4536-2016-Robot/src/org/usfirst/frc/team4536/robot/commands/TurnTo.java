package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.Utilities;
import org.usfirst.frc.team4536.robot.RectangleProfileForTurning;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team4536.robot.Constants;

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
    	
    	throttle = rectangle.throttle(time) - Constants.TURNING_RECTANGLE_GYRO_PROPORTIONALITY*(Utilities.angleDifference(rectangle.idealDistance(time), driveTrain.getNavXYaw()));
    	
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
