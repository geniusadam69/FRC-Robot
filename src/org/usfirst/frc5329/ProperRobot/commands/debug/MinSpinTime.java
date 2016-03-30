package org.usfirst.frc5329.ProperRobot.commands.debug;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MinSpinTime extends Command {
	private double angle; 
	private int time;
	private double speed;
	private double speedCounter;
	private double counter;
	private double counterLimit;
	private double endAngle;
	
	
	public MinSpinTime(double angle, int time){
		this.angle = angle;
		this.time = time;
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void initialize() {
		speed = 1.0;
		counterLimit =time/20;
		speedCounter = 0;
		endAngle = Robot.navx.getYaw() + angle;
		if (endAngle >=180) endAngle-=360;
		
	}

	@Override
	protected void execute() {
		if (speedCounter >= 5){
			speedCounter = 0;
			speed-=0.01;
		}
		
		Robot.drivetrain.setSpeed(speed, speed);
		speedCounter++;
	}

	@Override
	protected boolean isFinished() {
		
		
		
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
