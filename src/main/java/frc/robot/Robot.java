
package frc.robot;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Preferences;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.*;



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
	private static double robotSpeed = 0.35;
	public static CompressorSubsystem compSub;

	private Preferences prefs;


	public static double getRobotSpeed(){
		return robotSpeed;
	}


	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */


	public void robotInit() {
		RobotMap.init();
		solSub = new SolenoidSubsystem();
		compSub = new CompressorSubsystem();
		oi = new OI();

		prefs = Preferences.getInstance();
		robotSpeed = prefs.getDouble("RobotSpeed", 0.35);
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
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		robotSpeed = prefs.getDouble("RobotSpeed", 0.35);
		compSub.updateSmartDashboard();
		
		//dimLED();
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
	@Override
	public void testPeriodic() {
	}	
}