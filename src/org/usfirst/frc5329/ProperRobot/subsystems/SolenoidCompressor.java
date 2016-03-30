package org.usfirst.frc5329.ProperRobot.subsystems;

import org.usfirst.frc5329.ProperRobot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidCompressor extends Subsystem {                            //defines solenoids
     private DoubleSolenoid solenoid;
     
     public SolenoidCompressor() {
        solenoid = new DoubleSolenoid(0,1);  //Digtial I/O,Relay
    	solenoid.set(DoubleSolenoid.Value.kOff);
		solenoid.set(DoubleSolenoid.Value.kForward);
		solenoid.set(DoubleSolenoid.Value.kReverse);                       // Start the air compressor

     }
     public void operatorControl() {
      //    if(Robot.xboxController.isButtonYPressed() == true)
          {
               solenoid.set(DoubleSolenoid.Value.kForward);
           }
        //   if(Robot.xboxController.isButtonXPressed() == true)
           {
               solenoid.set(DoubleSolenoid.Value.kReverse);
            }
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
    }