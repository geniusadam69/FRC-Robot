package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class DriveXForwardWithPathCorrection extends PIDCommand {
	private double nFeet;
	private double tolerance = 0.5;
	private double speed;
	private final double MIN_SPEED = 0.22;
	
    public DriveXForwardWithPathCorrection(double feet) {
    	super(0.1, 0.001, 0);
    	requires(Robot.drivetrain);
    	nFeet = feet;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetEncoders();
    	speed = 0.5;
    	setSetpoint(nFeet);
    	
    }
    protected void execute() {
    	double speed = limitSpeed();
    	Robot.drivetrain.setSpeed(speed, -speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double distance = returnPIDInput();
    	return Math.abs(distance - nFeet) <= tolerance;
    }

    protected void end() {
    }

    
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		return (Robot.drivetrain.getLeftEncoder() + Robot.drivetrain.getRightEncoder())/2;
	}

	@Override
	protected void usePIDOutput(double output) {
		if (output<0)
			this.speed = output - MIN_SPEED;
		if (output > 0) this.speed = output+MIN_SPEED;
	}
	
	
	private double limitSpeed(){
		double maxSpeed = 1;
		double minSpeed = MIN_SPEED +0.05;
		
		double calcSpeed = (maxSpeed-minSpeed)*Math.abs(returnPIDInput() -nFeet) + minSpeed;
		
		if (Math.abs(calcSpeed) < speed){
			if (returnPIDInput() -nFeet<0) return calcSpeed;
			else return -calcSpeed;
		}
		
		return speed;
	}
	
}
