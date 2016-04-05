package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class TurnToNdegrees extends PIDCommand {
	private double Ndegrees;
	private double tolerance;
	private double speed;
	private int counter;
	private final double INPUT_SCALING_FACTOR =180;
	private final double MAX_SPEED = 0.65;
	private final double MIN_SPEED = 0.22;
	public TurnToNdegrees(double degrees){
		super(1.05, 0.025, 1); //0.2, 0.4, 0
		super.requires(Robot.drivetrain);
		Ndegrees = degrees;
	}
	

	@Override
	protected void initialize() {
		speed = 1.0;
		tolerance = 0.5;
		counter = 0;
		PIDController pc = super.getPIDController();
		pc.setInputRange(-180/INPUT_SCALING_FACTOR, 180/INPUT_SCALING_FACTOR);
		pc.setSetpoint(Ndegrees/INPUT_SCALING_FACTOR);
		pc.setContinuous(true);
		
	}

	@Override
	protected void execute() {
		//System.out.println("Executing");
		double calcSpeed = calculateConstraintController();
		
		if (Math.abs(Robot.navx.getYaw() - Ndegrees) <= tolerance) {
			Robot.drivetrain.setSpeed(0, 0);
		}
		else {
		Robot.drivetrain.setSpeed(calcSpeed, calcSpeed);
		}
		if (Math.abs(Robot.navx.getYaw() - Ndegrees) <= tolerance) 
		{ counter ++; }else {
			counter = 0;
			
		}
	}
	

	@Override
	protected boolean isFinished() {
		return (Math.abs(Robot.navx.getYaw() - Ndegrees) <= tolerance) && counter > 5;
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
		
		int neg = 1;
		if (output <0) {
			neg = -1;
			output = -output;
		}
		output += MIN_SPEED;
		//if (output > MAX_SPEED) output = MAX_SPEED;
		this.speed = neg*output;	
	}
	public PIDController getPIDController(){	
		return super.getPIDController();
	}
	
	public double calculateConstraintController(){
		//return speed;
		
		
		double maxSpeed = 1;
		double minSpeed = MIN_SPEED +0.05;
		double computedMaxSpeed = (maxSpeed  - minSpeed)*Math.abs(Robot.navx.getYaw() - Ndegrees)/INPUT_SCALING_FACTOR +minSpeed;
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
		double diff = angle - Ndegrees;
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
