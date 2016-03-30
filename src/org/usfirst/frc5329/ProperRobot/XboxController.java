package org.usfirst.frc5329.ProperRobot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class XboxController extends  Joystick{
private DriverStation _ds;
private final int _port;
private final Button buttonA;
private final Button buttonX;
private final Button buttonB;
private final Button buttonY;
private final Button LBumper;
private final Button RBumper;
private final Button select;
private final Button start;

public XboxController(int port) {
	super (port);
    _ds = DriverStation.getInstance();
    _port = port;
    buttonA = new JoystickButton(this, 1);
    buttonB = new JoystickButton(this, 2);
    buttonX = new JoystickButton(this, 3);
    buttonY = new JoystickButton(this, 4);
    LBumper = new JoystickButton(this, 5);
    RBumper = new JoystickButton(this, 6);
    select = new JoystickButton(this, 7);
    start = new JoystickButton(this, 8);
    
}

public double getRawAxis(final int axis) {
    return _ds.getStickAxis(_port, axis);
}

public boolean getRawButton(final int button) {
    return ((0x1 << (button - 1)) & _ds.getStickButtons(_port)) != 0;
}


public double getRightTrigger() {
    return Math.min(getRawAxis(3), 0);
}

public double getLeftTrigger() {
    return Math.max(getRawAxis(2), 0);
}

public double getRightJoyX() {
    return getRawAxis(4);
}

public double getRightJoyY() {
    return getRawAxis(5);
}

public double getLeftJoyX() {
    return getRawAxis(0);
}

public double getLeftJoyY() {
    return getRawAxis(1);
}

public boolean isButtonAPressed() {
    return getRawButton(1);
}


public boolean isButtonBPressed() {
    return getRawButton(2);
}

public boolean isButtonXPressed() {
    return getRawButton(3);
}

public boolean isButtonYPressed() {
	return getRawButton(4);
}
public boolean isLeftBumperPressed() {
	return getRawButton(5);
}
public boolean isRightBumperPressed() {
	return getRawButton(6);
}

public Button getButtonA(){
	return buttonA;
}
public Button getButtonB(){
	return buttonB;
}
public Button getButtonX(){
	return buttonX;
}
public Button getButtonY() {
    return buttonY;
}
public Button getRightBumper() {
	return RBumper;
}
public Button getLeftBumper() {
	return LBumper;
}
public Button getSelectButton() {
	return select;
}
public Button getStartButton() {
	return start;
}
public boolean getButtonBack() {
    return getRawButton(7);
}

public boolean getButtonStart() {
    return getRawButton(8);
}

public boolean getButtonRB() {
    return getRawButton(6);
}

public boolean getButtonLB() {
    return getRawButton(5);
}

public boolean getButtonLS() {
    return getRawButton(9);
}

public boolean getButtonRS() {
    return getRawButton(10);
}
}


