
package frc.robot;

import frc.robot.subsystems.ChangeLedValue;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.RunBlueOn;
import frc.robot.commands.RunBlueOff;
import frc.robot.commands.RunGreenOff;
import frc.robot.commands.RunGreenOn;
import frc.robot.commands.RunRedOff;
import frc.robot.commands.RunRedOn;
import frc.robot.subsystems.Drive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;


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
		SmartDashboard.putString("State ","" ); 
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();		
		
		oi.getRawAxis(5);	
		ledCommands();	
		
	}

	private void ledCommands(){
		ChangeLedValue rgbLed = new ChangeLedValue();
        
		if(oi.getRawAxis(5)> 0.34){

			rgbLed.setValue("red" ,  0);
			rgbLed.setValue("green" , 0);	
			rgbLed.setValue("blue" , 255);	
		}
		else if(oi.getRawAxis(5) < (-0.34)){
			rgbLed.setValue("blue" ,  0);
			rgbLed.setValue("red " ,  0);
			rgbLed.setValue("green" , 255);
		}
		else{
			rgbLed.setValue("green" , 0);
			rgbLed.setValue("blue" ,  0);
			rgbLed.setValue("red" , 255);
		
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
}