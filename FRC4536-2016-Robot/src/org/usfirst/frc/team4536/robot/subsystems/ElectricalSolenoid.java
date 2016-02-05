package org.usfirst.frc.team4536.robot.subsystems;

/**
 * @author sheila
 */
public class ElectricalSolenoid extends Piston {
	/**
	 * @param leftSolenoidChannel  channel the left solenoid is plugged into on the roboRIO
	 * @param rightSolenoidChannel  channel the right solenoid is plugged into on the roboRIO
	 */
	public ElectricalSolenoid(int leftSolenoidChannel, int rightSolenoidChannel) {
		super(leftSolenoidChannel, rightSolenoidChannel);
	}
}
