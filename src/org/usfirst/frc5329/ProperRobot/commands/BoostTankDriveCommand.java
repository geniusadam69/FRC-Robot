// This command is unused!


package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

public class BoostTankDriveCommand extends Command {
	public BoostTankDriveCommand() {
		requires(Robot.drivetrain);
	}
	@Override
	protected void initialize() {
		baseSpeed = 0.5;
	}

	public double baseSpeed;
	@Override
	protected void execute() {
		double leftValue;
		double rightValue;
		
		leftValue = Robot.oi.getLeftSpeed()*(-baseSpeed+(1-baseSpeed)*Robot.oi.getRightTrigger());
		rightValue = Robot.oi.getRightSpeed()*(baseSpeed+(1-baseSpeed)*Robot.oi.getRightTrigger());
		Robot.drivetrain.getRobotDrive().tankDrive(leftValue, rightValue); 
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
