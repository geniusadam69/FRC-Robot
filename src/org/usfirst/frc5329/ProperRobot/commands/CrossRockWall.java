package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CrossRockWall extends Command {
	
	
	private double speed;
	private final double MINIMUM_DISTANCE = 6;
	public CrossRockWall() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		speed = 1.0;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.drivetrain.resetEncoders();
		Robot.drivetrain.setSpeed(speed, -speed);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		double distanceTraveled;
		boolean pitchFlat= false;
		boolean minimumDistance= false;
		if (Robot.navx.getPitch() > (2) && Robot.navx.getPitch() < (-2)){
			pitchFlat = true;
		}
		distanceTraveled = (Robot.drivetrain.getLeftEncoder());
		if (distanceTraveled > MINIMUM_DISTANCE){
		minimumDistance = true;
		}
		while (pitchFlat == false || minimumDistance == false){
		
		}
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
