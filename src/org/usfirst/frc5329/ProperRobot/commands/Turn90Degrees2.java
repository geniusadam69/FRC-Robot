package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class Turn90Degrees2 extends PIDCommand {
	private float endPoint;
	private double tolerance;
	private float yawOffset = 0;
	private float lastYawValue;
	private double speed;
	private int counter;
	private final double INPUT_SCALING_FACTOR =180;
	private final double MAX_SPEED = 0.65;
	private final double MIN_SPEED = 0.22;
	public Turn90Degrees2(){
		super(1, 0.05, 0);
		super.requires(Robot.drivetrain);
		
	}

	@Override
	protected void initialize() {
		endPoint = Robot.navx.getYaw() -90;
		if (endPoint < -180) { 
			endPoint += 360;
		}
		lastYawValue = Robot.navx.getYaw();
		speed = 1.0;
		setSetpoint(endPoint/INPUT_SCALING_FACTOR);
		tolerance = .5;
		counter = 0;
		PIDController pc = super.getPIDController();
		pc.setInputRange(-180/INPUT_SCALING_FACTOR, 180/INPUT_SCALING_FACTOR);
		pc.setOutputRange(-(MAX_SPEED-MIN_SPEED), MAX_SPEED-MIN_SPEED);
		pc.setContinuous(true);
		
	}

	@Override
	protected void execute() {
		//System.out.println("Executing");
		double calcSpeed = calculateConstraintController();
		Robot.drivetrain.setSpeed(calcSpeed, calcSpeed);
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
		System.out.println("End point:  "  +endPoint + " Current: " + Robot.navx.getYaw());
		System.out.println("Output:  " + output);
		int neg = 1;
		if (output <0) {
			neg = -1;
			output = -output;
		}
		output += MIN_SPEED;
		//if (output > MAX_SPEED) output = MAX_SPEED;
		this.speed = neg*output;
		System.out.println("Speed: " + speed);
	
		this.speed = output;
	}

	
	public PIDController getPIDController(){
		
		return super.getPIDController();
	}
	
	public double calculateConstraintController(){
		//return speed;
		
		
		double maxSpeed = 1;
		double minSpeed = MIN_SPEED +0.05;
		double computedMaxSpeed = (maxSpeed  - minSpeed)*Math.abs(Robot.navx.getYaw() - endPoint)/INPUT_SCALING_FACTOR +minSpeed;
		if (Math.abs(computedMaxSpeed) <Math.abs(speed)) {
			System.out.println("Computed max speed Constraint");
			return computedMaxSpeed * getDirection();
		}
		else {
			return speed;
		}
		
	}
	public int getDirection(){
		double angle = Robot.navx.getYaw();
		double diff = angle - endPoint;
		if (diff >180){
			return 1;
		}else if (diff <-180){
			return -1;
		}
		
		if (diff<0){
			
			return 1;
		}else {
			return -1;
		}
	}
	
}