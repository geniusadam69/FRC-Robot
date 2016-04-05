package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class TurnToNdegrees extends PIDCommand {
	private double nDegrees;
	private double tolerance;
	private double speed;
	private int counter;
	
	private final double INPUT_SCALING_FACTOR =180;
	private final double MAX_SPEED = 0.65;
	private final double MIN_SPEED = 0.28;
	
	public TurnToNdegrees(double degrees){
		super(1.05, 0.025, 1); //0.2, 0.4, 0
		super.requires(Robot.drivetrain);
		nDegrees = degrees;
	}
	

	@Override
	protected void initialize() {
		speed = 1.0;
		tolerance = 0.5;
		counter = 0;
		
		PIDController pc = super.getPIDController();
		pc.setSetpoint(nDegrees/INPUT_SCALING_FACTOR);
		pc.setContinuous(true);
		pc.setInputRange(-180/INPUT_SCALING_FACTOR, 180/INPUT_SCALING_FACTOR);
		
	}

	@Override
	protected void execute() {
		//System.out.println("Executing");
		if (Math.abs(Robot.navx.getYaw() - nDegrees) <= tolerance) {
			speed = 0;
			counter++;
		}else{
			counter = 0;
		}
		
		Robot.drivetrain.setSpeed(speed, speed);
		
	}
	

	@Override
	protected boolean isFinished() {
		return  counter > 5;
	}

	@Override
	protected void end() {
	
		
	}

	@Override
	protected void interrupted() {
		
		
	}

	@Override
	protected double returnPIDInput() {
		return Robot.navx.getYaw() / INPUT_SCALING_FACTOR;
	}

	@Override
	protected void usePIDOutput(double output) {
		this.speed = limitSpeedOld(output);
	}
	
	public double limitSpeedOld(double speed){
		System.out.println("Error:  " + getPIDController().getError());
		double error = getPIDController().getError();
		if (error<0) {
			if (speed <-MAX_SPEED){
				speed = -MAX_SPEED;
				System.out.println("negative max speed");
			}
			else if (speed > -MIN_SPEED){
				speed = -MIN_SPEED;
				System.out.println("negative min speed");
			}else{
				speed = -Math.abs(speed);
				System.out.println("negative computed speed");
			}
		}else{
			if (speed >MAX_SPEED){
				speed = MAX_SPEED;
				System.out.println("positive max speed");
			}
			else if (speed < MIN_SPEED){
				speed = MIN_SPEED;
				System.out.println("positive min speed");
			}else{
				speed = Math.abs(speed);
				System.out.println("positive computed speed");
			}
		}
		return speed;
	}
	public double limitSpeedOld2(double speed){
		if (speed <-MAX_SPEED){
			speed = -MAX_SPEED;
			System.out.println("negative max speed");
		}else if (speed >MAX_SPEED){
			speed = MAX_SPEED;
			System.out.println("positive max speed");
		} else if (speed > -MIN_SPEED && speed < 0){
			speed = -MIN_SPEED;
			System.out.println("negative min speed");
		}else if (speed < MIN_SPEED && speed >0){
				speed = MIN_SPEED;
				System.out.println("positive min speed");
		}else{
			System.out.println("Calculated Speed");
		}
		return speed;
	}
	public double limitSpeedWithMinAdj(double speed){
		if (speed >0){
			speed += MIN_SPEED;
			if (speed >MAX_SPEED) speed = MAX_SPEED;
		}else{
			speed-=MIN_SPEED;
			if (speed<-MAX_SPEED) speed = -MAX_SPEED;
		}
		return speed;
	}
	
	
	public PIDController getPIDController(){	
		return super.getPIDController();
	}
}
