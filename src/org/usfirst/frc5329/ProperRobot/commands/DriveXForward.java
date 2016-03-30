package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class DriveXForward extends PIDCommand {
	private double endPoint;
	private double distance;
	private double nFeet;
	private double tolerance = 0.5;
	private double distanceOffset = 0;
	private double lastDistanceValue;
	private double speed;
	private final double INPUT_SCALING_FACTOR =1;
    public DriveXForward(double feet) {
    	super(0.1, 0.001, 0);
    	super.requires(Robot.drivetrain);
    	nFeet = feet;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	distance = Math.pow(Math.pow(Robot.navx.getDisplacementX(),2) + Math.pow(Robot.navx.getDisplacementY(), 2), 0.5);
    	endPoint = distance + nFeet;
    	speed = 1.0;
    	setSetpoint(endPoint/INPUT_SCALING_FACTOR);
    	PIDController pc = super.getPIDController();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.setSpeed(speed, -speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return distance - endPoint <= tolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		return distance / INPUT_SCALING_FACTOR;
	}

	@Override
	protected void usePIDOutput(double output) {
		System.out.println("Error: " + getPIDController().getError());
		if (output>0.15) output = 0.15;
		if (output<-0.15) output = -0.15;
		this.speed = output;
		// TODO Auto-generated method stub
		
	}
}
