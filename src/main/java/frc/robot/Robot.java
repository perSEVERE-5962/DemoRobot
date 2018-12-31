
package frc.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import frc.robot.commands.RunGreenOn;
import frc.robot.subsystems.*;



/* The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Drive drive = new Drive();
	
	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */


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

		dimLED();
	}

	private void dimLED() {
		double value=oi.getRawAxis(1);
		int newvalue=0;
		if (value==1){
			newvalue=0;	
		} else if(value>0.34){
			newvalue=50;
		} else if(value==-1){
			newvalue=255;
		} else if(value<-0.34){
			newvalue=197;
		} else {
			newvalue=127;
		}
		ChangeLedValue led=new ChangeLedValue();
		led.setvalue("green",newvalue);	
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}