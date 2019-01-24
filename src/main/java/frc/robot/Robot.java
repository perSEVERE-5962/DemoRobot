
package frc.robot;

<<<<<<< HEAD

import edu.wpi.first.wpilibj.TimedRobot;
=======
import frc.robot.subsystems.ChangeLedValue;
import edu.wpi.first.wpilibj.IterativeRobot;
>>>>>>> YashP
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.RunBlueOn;
import frc.robot.commands.RunBlueOff;
import frc.robot.commands.RunGreenOff;
import frc.robot.commands.RunGreenOn;
import frc.robot.commands.RunRedOff;
import frc.robot.commands.RunRedOn;
import frc.robot.subsystems.Drive;
<<<<<<< HEAD
import frc.robot.subsystems.*;
=======
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
>>>>>>> YashP


/* The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

	public static OI oi;
	public static Drive drive = new Drive();
	public static SolenoidSubsystem solSub;	

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */


	public void robotInit() {
		RobotMap.init();
		oi = new OI();
		solSub = new SolenoidSubsystem();
	}
	
  	/**
   	 * This function is called every robot packet, no matter the mode. Use
   	 * this for items like diagnostics that you want ran during disabled,
   	 * autonomous, teleoperated and test.
   	 *
   	 * <p>This runs after the mode specific periodic functions, but before
   	 * LiveWindow and SmartDashboard integrated updating.
   	 */
	@Override
	public void robotPeriodic() {
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		oi.startDriveCommand();	
		SmartDashboard.putString("State ","" ); 
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
<<<<<<< HEAD
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
=======
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
>>>>>>> YashP
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
	
}