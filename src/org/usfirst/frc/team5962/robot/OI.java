package org.usfirst.frc.team5962.robot;


import org.usfirst.frc.team5962.robot.commands.Throttle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5962.robot.commands.RGBLedRedOff;
import org.usfirst.frc.team5962.robot.commands.RGBLedRedOn;
import org.usfirst.frc.team5962.robot.commands.RGBLedGreenOff;
import org.usfirst.frc.team5962.robot.commands.RGBLedGreenOn;
import org.usfirst.frc.team5962.robot.commands.RGBLedBlueOff;
import org.usfirst.frc.team5962.robot.commands.RGBLedBlueOn;
import org.usfirst.frc.team5962.robot.commands.RGBLedYellowOff;
import org.usfirst.frc.team5962.robot.commands.RGBLedYellowOn;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	public Joystick joystickLeft;
	public Joystick joystickRight;
	public Joystick gamepad1;
	public Joystick xBoxController;

	public OI() {
		joystickLeft = new Joystick(1);
		joystickRight = new Joystick(2);
		gamepad1 = new Joystick(0);
		xBoxController = new Joystick(3);
	}
	
	public void startDriveCommand() {
	Command command = new RunJoystickTank();
	command.start();
	}
	
	public double joystickLeftAxis() {
		return joystickLeft.getRawAxis(1);
	}
	
	public double joystickLeftThrottleAxis() {
		return joystickLeft.getRawAxis(3);
	}
	
	public double joystickRightAxis() {
		return joystickRight.getRawAxis(1);
	}
	
	public double joystickRightThrottleAxis() {
		return joystickRight.getRawAxis(3);
	}
	
	public double gamepadLeftAxis() {
		return gamepad1.getRawAxis(1);
	}
	public double gamepadRightAxis() {
		return gamepad1.getRawAxis(5);
	}
	
	public double gamePadLeftTrigger() {
		return gamepad1.getRawAxis(2);
	}
	
	public double gamePadRightTrigger() {
		return gamepad1.getRawAxis(3);
	}
	
	public double xBoxLeftAxis() {
		return xBoxController.getRawAxis(1);
	}
	
	public double xBoxRightAxis() {
		return xBoxController.getRawAxis(5);
	}
	
	public double xBoxLeftTrigger() {
		return xBoxController.getRawAxis(2);
	}
	
	public double xBoxRightTrigger() {
		return xBoxController.getRawAxis(3);
	}
}