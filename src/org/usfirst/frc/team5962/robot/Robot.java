
package org.usfirst.frc.team5962.robot;


import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team5962.robot.subsystems.Drive;

public class Robot extends IterativeRobot {

	public static Command autonomousCommand;
	public static OI oi;
	public static Drive drive = new Drive();

	public void robotInit() {
		RobotMap.init();
		oi = new OI();
	}

	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		oi.startDriveCommand();	
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();		
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}