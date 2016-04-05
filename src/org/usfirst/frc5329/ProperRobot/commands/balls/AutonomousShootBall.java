package org.usfirst.frc5329.ProperRobot.commands.balls;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousShootBall extends Command {

	public AutonomousShootBall() {
		requires(Robot.ballCollector);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		Robot.ballCollector.reverseSpinner();
    	Robot.ballCollector.close();

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
