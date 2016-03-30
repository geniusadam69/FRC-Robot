package org.usfirst.frc5329.ProperRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5329.ProperRobot.Robot;

public class CrossLowBar extends Command {
	
	private double speed;
	private final double MINIMUM_DISTANCE = 1; 
	public CrossLowBar() {
		requires(Robot.drivetrain);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		speed = 0.5;
		
		//savedDistance = Robot.encoder.distance;
		 //We want current distance to update as we go, not stay as 0
		// TODO Auto-generated method stub
		Robot.navx.reset();
		
	}

	@Override
	protected void execute() {
	//Robot.drivetrain.resetEncoders();
		Robot.drivetrain.setSpeed(speed, -speed);
	}

	
		// TODO Auto-generated method stub
		
	

	@Override
	protected boolean isFinished() {
		double distanceTraveled;
		boolean pitchFlat= false;
		boolean minimumDistance= true;
		if (Robot.navx.getPitch() < (1) && Robot.navx.getPitch() > (-1)){
			pitchFlat = true;
		}
		//distanceTraveled = (Robot.drivetrain.getLeftEncoder());
		distanceTraveled = Robot.navx.getDisplacementX();
		if (distanceTraveled > MINIMUM_DISTANCE){
			minimumDistance = true;
		}
		System.out.println(pitchFlat + " " + Robot.navx.getDisplacementX());
		if (pitchFlat == false || minimumDistance == false){
			
			 return false;
		}
		return true;
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
