package org.usfirst.frc5329.ProperRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc5329.ProperRobot.Robot;

public class CrossLowBar extends Command {
	
	private double speed;
	private int count_time;
	private int pitch_time;
	private int Minimum_Pitch = 10;
	private int Minimum_Time = 65;
	private final double MINIMUM_DISTANCE = 7; 
	public CrossLowBar() {
		requires(Robot.drivetrain);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initialize() {
		speed = 0.70;
		count_time = 0;
		pitch_time = 0;
		Robot.drivetrain.resetEncoders();
		//savedDistance = Robot.encoder.distance;
		 //We want current distance to update as we go, not stay as 0
		// TODO Auto-generated method stub
		Robot.navx.reset();
		
	}

	@Override
	protected void execute() {
	//Robot.drivetrain.resetEncoders();
		Robot.drivetrain.setSpeed(speed, -speed);
		count_time ++;
		if (Robot.navx.getPitch() < (2) && Robot.navx.getPitch() > (-2)){
			pitch_time ++;
		}
	}

	
		// TODO Auto-generated method stub
		
	

	@Override
	protected boolean isFinished() {
		double distanceTraveled;
		boolean pitchFlat = false;
		boolean minimumTime = false;
		boolean minimumDistance= false;
		if (Robot.navx.getPitch() < (2) && Robot.navx.getPitch() > (-2) && pitch_time > Minimum_Pitch){
			pitchFlat = true;
		}
		//distanceTraveled = (Robot.drivetrain.getLeftEncoder());
		distanceTraveled = Robot.drivetrain.getRightEncoder();
		if (distanceTraveled > MINIMUM_DISTANCE){
			minimumDistance = true;
		}
		if (count_time > Minimum_Time){
			minimumTime = true;
		}
		System.out.println(pitchFlat + " " + Robot.drivetrain.getRightEncoder());
		if (pitchFlat == true && minimumTime == true && minimumDistance == true){
			 return true;
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
