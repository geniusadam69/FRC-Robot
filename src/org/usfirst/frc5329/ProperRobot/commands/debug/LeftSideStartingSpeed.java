package org.usfirst.frc5329.ProperRobot.commands.debug;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LeftSideStartingSpeed extends Command{
	private double speed = 0.0;
	private int speedCounter;
	private int cycleCounter= 0;
	private double cycles;
	private double lastEncoder;
	private final DrivetrainCollect dtc;
	public LeftSideStartingSpeed(double cycles, DrivetrainCollect dtc){
		this.cycles = cycles;
		this.dtc = dtc;
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void initialize() {
		speed = 0.0;
		speedCounter = 0;
		cycleCounter = 0;
		lastEncoder = Robot.drivetrain.getLeftEncoder();
	}

	@Override
	protected void execute() {
		if (speedCounter>=5){
			speedCounter = 0;
			speed +=0.01;
		}
		Robot.drivetrain.setSpeed(speed, 0.0);
		speedCounter++;
	}

	@Override
	protected boolean isFinished() {
		if (Robot.drivetrain.getLeftEncoder() > lastEncoder){
			cycleCounter++;
		}else{
			cycleCounter = 0;
		}
		lastEncoder = Robot.drivetrain.getLeftEncoder();
		if (cycleCounter>=cycles){
			return true;
		}
		return false;
	}

	@Override
	protected void end() {
		dtc.setStartingLeftMotor(speed);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
