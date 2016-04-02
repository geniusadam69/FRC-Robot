package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectBall extends Command {

    public CollectBall() {
    	requires(Robot.ballCollector);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ballCollector.forwardSpinner();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ! Robot.oi.getLeftBumper().get(); //Robot.oi.getLeftBumper().get();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
