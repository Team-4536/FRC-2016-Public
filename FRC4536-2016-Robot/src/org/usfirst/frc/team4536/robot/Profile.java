package org.usfirst.frc.team4536.robot;

//TODO add protected members for proportionality and integral constants
public abstract class Profile {
	
	public abstract double leftThrottle(double time);
	public abstract double rightThrottle(double time);
	public abstract double idealVelocity(double time);
	public abstract double idealAngularVelocity(double time);
	public abstract double idealLeftDistance(double time);
	public abstract double idealRightDistance(double time);
	public abstract double idealAngle(double time);
	public abstract double getTimeNeeded();
	public abstract double getLeftDistance();
	public abstract double getRightDistance();
	public abstract double getAngle();
	public abstract void setAngle(double angle);
}
