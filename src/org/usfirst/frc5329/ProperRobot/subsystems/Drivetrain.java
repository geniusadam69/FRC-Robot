// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5329.ProperRobot.subsystems;

import org.usfirst.frc5329.ProperRobot.RobotMap;
import org.usfirst.frc5329.ProperRobot.commands.*;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Drivetrain extends Subsystem {

    private  SpeedController frontLeftSpeedCon;
    private  SpeedController backLeftSpeedCon;
    private  SpeedController frontRightSpeedCon;
    private  SpeedController backRightSpeedCon;
    private  RobotDrive robotDrive41;
    private  Counter leftEncoder;
    public  Counter rightEncoder;
    public final double DPP = 0.01/2.22;
    
	private final double k_updatePeriod = 0.005; // update every 0.005 seconds/5 milliseconds (200Hz)

    public Drivetrain(RobotMap robotMap) {
    	this.frontLeftSpeedCon = robotMap.getFrontLeftSpeed();
    	this.frontRightSpeedCon = robotMap.getFrontRightSpeed();
    	this.backRightSpeedCon = robotMap.getBackRightSpeed();
    	this.backLeftSpeedCon = robotMap.getBackLeftSpeed();
    	this.robotDrive41 = robotMap.getRobotDrive();
    	//this.rightEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k1X);
    	//this.leftEncoder = new Encoder(2,3, false, Encoder.EncodingType.k4X); //issues
    	
    	this.leftEncoder = new Counter(0);
    	this.rightEncoder = new Counter(3);
    	rightEncoder.setDistancePerPulse(DPP);
    	leftEncoder.setDistancePerPulse(DPP);
    	
    }

	protected void initDefaultCommand() {
		TankDriveCommand command = new TankDriveCommand();
		this.setDefaultCommand(command);
	}
	public RobotDrive getRobotDrive(){
		return robotDrive41;
	}
	public void setSpeed(double leftSpeed, double rightSpeed){
		frontLeftSpeedCon.set(leftSpeed);
		frontRightSpeedCon.set(rightSpeed);
		backLeftSpeedCon.set(leftSpeed);
		backRightSpeedCon.set(rightSpeed);
		
	}

	
	public double getLeftEncoder(){
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoder(){
		return rightEncoder.getDistance();
	}
    public void resetEncoders(){
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public Counter getRightEncoderObject(){
    	return rightEncoder;    }
    public Counter getLeftEncoderObject(){
    	return leftEncoder;
    }
    public void setRightEncoderNegative(){
    	rightEncoder.setDistancePerPulse(-DPP);
    }
    public void setRightEncoderPositive(){
    	rightEncoder.setDistancePerPulse(DPP);
    }
 }

