package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class TurnToNdegrees extends PIDCommand {
	private double endPoint;
	private double Ndegrees;
	private double tolerance;
	private double yawOffset = 0;
	private double lastYawValue;
	private double speed;
	private int counter;
	private final double INPUT_SCALING_FACTOR =180;
	private final double MAX_SPEED = 0.65;
	private final double MIN_SPEED = 0.28;
	public TurnToNdegrees(double degrees){
		super(1.05, 0.025, 1); //0.2, 0.4, 0
		super.requires(Robot.drivetrain);
		Ndegrees = degrees;
	}
	

	@Override
	protected void initialize() {
		endPoint = Robot.navx.getYaw() + Ndegrees;
		if (endPoint > 180) { 
			endPoint -= 360;
		}
		lastYawValue = Robot.navx.getYaw();
		speed = 1.0;
		tolerance = 0.5;
		counter = 0;
		
		PIDController pc = super.getPIDController();
		pc.setSetpoint(endPoint/INPUT_SCALING_FACTOR);
		pc.setContinuous(true);
		pc.setInputRange(-180/INPUT_SCALING_FACTOR, 180/INPUT_SCALING_FACTOR);
		
	}

	@Override
	protected void execute() {
		//System.out.println("Executing");
		if (Math.abs(Robot.navx.getYaw() - endPoint) <= tolerance) {
			Robot.drivetrain.setSpeed(0, 0);
		}
		else {
		Robot.drivetrain.setSpeed(speed, speed);
		}
		if (Math.abs(Robot.navx.getYaw() - endPoint) <= tolerance) 
		{ counter ++; }else {
			counter = 0;
			
		}
	}
	

	@Override
	protected boolean isFinished() {
		return (Math.abs(Robot.navx.getYaw() - endPoint) <= tolerance) && counter > 5;
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
		//System.out.println(getPIDController().);
		System.out.println("Error:  " + getPIDController().getError());
		double error = getPIDController().getError();
		if (error<0) {
			if (output <-MAX_SPEED){
				output = -MAX_SPEED;
				System.out.println("negative max speed");
			}
			else if (output > -MIN_SPEED){
				output = -MIN_SPEED;
				System.out.println("negative min speed");
			}else{
				output = -Math.abs(output);
				System.out.println("negative computed speed");
			}
		}else{
			if (output >MAX_SPEED){
				output = MAX_SPEED;
				System.out.println("positive max speed");
			}
			else if (output < MIN_SPEED){
				output = MIN_SPEED;
				System.out.println("positive min speed");
			}else{
				output = Math.abs(output);
				System.out.println("positive computed speed");
			}
		}
		this.speed = output;
		
	}

	
	public PIDController getPIDController(){
		
		return super.getPIDController();
	}
}
