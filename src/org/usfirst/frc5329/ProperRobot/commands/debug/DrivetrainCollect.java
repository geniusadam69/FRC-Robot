package org.usfirst.frc5329.ProperRobot.commands.debug;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DrivetrainCollect extends CommandGroup{
	private double startingLeftMotor = 0;
	private double startingRightMotor = 0;
	private final double cyclesWithMovementForStartingSpeed = 5;
	private double spinTimeToAchieve90Degrees = 0;
	private double spinTimeSpeed = 0;
	private double minSpeedTolerance = 0.5;
	
	
	public DrivetrainCollect(){
		addSequential(new LeftSideStartingSpeed(cyclesWithMovementForStartingSpeed, this));
		addSequential(new RightSideStartingSpeed(cyclesWithMovementForStartingSpeed, this));
	}
	
	
	
	public double getStartingLeftMotor() {
		return startingLeftMotor;
	}
	public void setStartingLeftMotor(double startingLeftMotor) {
		this.startingLeftMotor = startingLeftMotor;
	}
	public double getStartingRightMotor() {
		return startingRightMotor;
	}
	public void setStartingRightMotor(double startingRightMotor) {
		this.startingRightMotor = startingRightMotor;
	}
	public double getSpinTimeToAchieve90Degrees() {
		return spinTimeToAchieve90Degrees;
	}
	public void setSpinTimeToAchieve90Degrees(double spinTimeToAchieve90Degrees) {
		this.spinTimeToAchieve90Degrees = spinTimeToAchieve90Degrees;
	}
	public double getSpinTimeSpeed() {
		return spinTimeSpeed;
	}
	public void setSpinTimeSpeed(double spinTimeSpeed) {
		this.spinTimeSpeed = spinTimeSpeed;
	}
	public double getMinSpeedTolerance() {
		return minSpeedTolerance;
	}
	public void setMinSpeedTolerance(double minSpeedTolerance) {
		this.minSpeedTolerance = minSpeedTolerance;
	}
	

	
	
}
