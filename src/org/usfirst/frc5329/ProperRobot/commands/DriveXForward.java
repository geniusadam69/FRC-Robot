package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;

/**
 *
 */
public class DriveXForward extends PIDCommand {
	private double nFeet;
	private final double tolerance = 0.1;
	private double speed;
	private final double MIN_SPEED = 0.22;
	private final double MAX_SPEED = 0.55;
	private double lastSpeed;
	private final double rampUpLimit = 0.05;
	private final double rampDownLimit = 0.3;
	
	//path Correction parameters
	private final double pathKp = 0.1;  //This is not a true Kp.  It's a reduction factor for the over-contributing motor
	private final double lastErrorWeight=0.2;
	private double lastError;
	private double initialHeader;
	
	
    public DriveXForward(double feet) {
    	super(0.2, 0, 0.5);
    	requires(Robot.drivetrain);
    	nFeet = feet;
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Normal Drive");
    	Robot.drivetrain.resetEncoders();
    	speed = 0.25;
    	setSetpoint(nFeet);
    	initialHeader = Robot.navx.getYaw();
    	
    }
    protected void execute() {
    	//double speed = rampSpeed(limitSpeed());
    	double speed = rampSpeed(this.speed);
    	System.out.println(speed);
    	lastSpeed = speed;
    	this.speed = speed;
    	//this error should be between -1 and 1 but could go all the way to -2 to t2
    	double error = (Robot.navx.getYaw() - initialHeader)/180 + lastError*lastErrorWeight;
    	
    	if (error < -1) error = -1;
    	if (error >1) error = 1;
    	lastError = error;
    	double leftSpeed = speed;
    	double rightSpeed = speed;
    	//whichever side is leading, reduce the speed by a factor times the error; 
    	if (error<0) rightSpeed -= pathKp*(1+error);
    	if (error>0) leftSpeed -=pathKp* (1-error);
    	
    	Robot.drivetrain.setSpeed(leftSpeed, -rightSpeed);
    	/*if (rightSpeed < 0){
    		Robot.drivetrain.setRightEncoderNegative();
    	} else {
    		Robot.drivetrain.setRightEncoderPositive();
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double distance = returnPIDInput();
    	System.out.println(speed + " " + Math.abs(distance-nFeet));
    	return Math.abs(distance - nFeet) <= tolerance;
    	
    }

    protected void end() {
    }

    
    protected void interrupted() {
    }

	@Override
	protected double returnPIDInput() {
		return (Robot.drivetrain.getRightEncoder());
	}

	@Override
	protected void usePIDOutput(double output) {
		if (output<0)
			this.speed = output - MIN_SPEED;
		if (output > 0) this.speed = output+MIN_SPEED;
		if (output>MAX_SPEED) output = MAX_SPEED;
		if (output<-MAX_SPEED) output = -MAX_SPEED;
	}
	
	
	private double limitSpeed(){
		double maxSpeed = 1;
		double minSpeed = MIN_SPEED;
		double constraintDistance = 4;
		
		double calcSpeed = (maxSpeed-minSpeed)*Math.abs(returnPIDInput() -nFeet)/constraintDistance + minSpeed;
		System.out.println("Calc: " + calcSpeed);
		if (Math.abs(calcSpeed) < speed){
			System.out.println("Constrained");
			
			if (returnPIDInput() -nFeet<0) return calcSpeed;
			else return -calcSpeed;
		}
		
		return speed;
	}
	private double rampSpeed(double speed){
		double rampSpeed;
		if (speed-lastSpeed > rampUpLimit){
			rampSpeed = lastSpeed+rampUpLimit;
			System.out.println("Ramp up");
		}
		else if (speed-lastSpeed < -rampDownLimit){
			rampSpeed = lastSpeed-rampDownLimit;
			System.out.println("Ramp Down");
		}
		else{
			System.out.println("No Ramp");
			rampSpeed = speed;
		}
		return rampSpeed;
	}
	
}
