package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CrossRoughTerrain extends Command {
	public double speed;
	public final double MINIMUM_DISTANCE = 3;

	public CrossRoughTerrain() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		speed = 0.5;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.drivetrain.resetEncoders();
		Robot.drivetrain.setSpeed(speed, -speed);
	}
		// TODO Auto-generated method stub
		
	

	@Override
	protected boolean isFinished() {
		double distanceTraveled;
		boolean pitchFlat= false;
		boolean minimumDistance= false;
		if (Robot.navx.getPitch() > (1) && Robot.navx.getPitch() < (-1)){
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
