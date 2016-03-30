package org.usfirst.frc5329.ProperRobot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public interface RobotMap {
	public  SpeedController getFrontLeftSpeed();

	
	public SpeedController getBackLeftSpeed() ;

	

	public SpeedController getFrontRightSpeed();

	
	public SpeedController getBackRightSpeed();

	public SpeedController getRollerSpeed();
	
	public RobotDrive getRobotDrive();
	public void init();
}
