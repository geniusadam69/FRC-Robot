package org.usfirst.frc5329.ProperRobot.subsystems;

import org.usfirst.frc5329.ProperRobot.RobotMap;
import org.usfirst.frc5329.ProperRobot.commands.ResetPneumatic;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class BallCollector extends Subsystem {
	public DoubleSolenoid solenoid;
	private SpeedController rollerSpeed;
	public  BallCollector() {
		solenoid = new DoubleSolenoid(0,1);
	
	
	}
	public BallCollector(RobotMap robotMap){
		this();
		this.rollerSpeed = robotMap.getRollerSpeed();
	}
	
	
	public void open() { // this makes it open
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close(){ // this makes it close
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void reset(){
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	public void reverseSpinner(){
		rollerSpeed.set(-1);
	}
	public void forwardSpinner(){
		rollerSpeed.set(0.50);
	}
	public void disableSpinner90(){
		rollerSpeed.set(0);
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void initDefaultCommand() {
    	ResetPneumatic resetpneumatic;
    	resetpneumatic = new ResetPneumatic();
    	this.setDefaultCommand(resetpneumatic);
    	
    	
        
    }
}




