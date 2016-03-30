package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class TurnToNDegrees extends PIDCommand {
	private static final double Kp=1;
	private static final double Ki=0;
	private static final double Kd=0;
	private static final double MAX_SPEED_ANGLE = .25;
	private static final double MAX_SPEED_ANGLE_2 = .5;
	private static final double MAX_SPEED=0.15;
	private static final double MAX_SPEED2 = .3; 
	private static final double TOLERANCE = 0.5;
	private static final double INITIAL_SPEED = 1.0;//PEANUT		
	private double angle;
	private PIDController pc;
	private double endPoint;
	
	private double speed;
	
	public TurnToNDegrees(double angle) {
		super(Kp, Ki, Kd);
		super.requires(Robot.drivetrain);
		this.angle = angle;
		this.pc = super.getPIDController();
		pc.setContinuous(true);
		pc.setInputRange(-1, 1);

		// TODO Auto-generated constructor stub
	}


	@Override
	protected double returnPIDInput() {
		return Robot.navx.getYaw();
	}

	@Override
	protected void usePIDOutput(double output) {
		this.speed = output;
		//Fix speed if too much
		if (Math.abs(pc.getError())<MAX_SPEED_ANGLE && speed>MAX_SPEED) speed = MAX_SPEED;
		if (Math.abs(pc.getError())<MAX_SPEED_ANGLE_2 && speed>MAX_SPEED2) speed = MAX_SPEED2;
		if (Math.abs(pc.getError())<MAX_SPEED_ANGLE && speed>-MAX_SPEED) speed = MAX_SPEED;
		if (Math.abs(pc.getError())<MAX_SPEED_ANGLE_2 && speed>-MAX_SPEED2) speed = MAX_SPEED2;

	}

	@Override
	protected void initialize() {
		endPoint = angle;
		if (endPoint > 180) { 
			endPoint -= 360;
		}
		speed = INITIAL_SPEED;
		setSetpoint(endPoint/180);
	}

	@Override
	protected void execute() {
		Robot.drivetrain.setSpeed(speed, speed);

	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.navx.getYaw() - angle) <TOLERANCE;
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
