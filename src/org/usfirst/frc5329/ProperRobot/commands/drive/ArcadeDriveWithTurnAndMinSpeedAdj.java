package org.usfirst.frc5329.ProperRobot.commands.drive;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveWithTurnAndMinSpeedAdj extends Command {
	private static final double MIN_SPEED = 0.15;
	private static final double JOYSTICK_TOLERANCE = 0.01;
	public ArcadeDriveWithTurnAndMinSpeedAdj(){
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		double leftStickForward = -Robot.oi.getLeftSpeed();
		double rightStickSide = -Robot.oi.getRightStickLeftRight();
		double leftTrigger = Robot.oi.getLeftTrigger();
		double rightTrigger = Robot.oi.getRightTrigger();
		
		double moveValue;
		
		if (leftStickForward> 0 && leftStickForward >JOYSTICK_TOLERANCE) moveValue = leftStickForward + MIN_SPEED;
		else if(leftStickForward <0 && leftStickForward <-JOYSTICK_TOLERANCE) moveValue = leftStickForward-MIN_SPEED;
		else moveValue = 0;
		
		double rotateValue = rightStickSide +leftTrigger -rightTrigger;
		if (rotateValue > 1) rotateValue = 1;
		if (rotateValue <-1) rotateValue = -1; 
		Robot.drivetrain.getRobotDrive().arcadeDrive(moveValue, rotateValue);

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
