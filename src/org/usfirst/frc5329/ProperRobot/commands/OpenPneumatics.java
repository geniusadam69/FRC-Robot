package org.usfirst.frc5329.ProperRobot.commands;

import org.usfirst.frc5329.ProperRobot.Robot;
//import org.usfirst.frc5329.ProperRobot.XboxController;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.SolenoidBase;
/**
 *
 */
public class OpenPneumatics extends Command {
	
    public OpenPneumatics() {
    requires(Robot.ballCollector);
    
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ballCollector.open();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return ! Robot.oi.getButtonY().get();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
