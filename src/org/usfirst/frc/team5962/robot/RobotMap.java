package org.usfirst.frc.team5962.robot;

import org.usfirst.frc.team5962.robot.sensors.RobotUltrasonicAnalog;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	private final static int PWM_CHANNEL_0 = 0;
	private final static int PWM_CHANNEL_1 = 1;
	private final static int PWM_CHANNEL_2 = 2;
	private final static int PWM_CHANNEL_3 = 3;
	private final static int PWM_CHANNEL_4 = 4;
	private final static int PWM_CHANNEL_5 = 5;
	private final static int PWM_CHANNEL_6 = 6;
	private final static int PWM_CHANNEL_7 = 7;
	private final static int PWM_CHANNEL_8 = 8;
	private final static int PWM_CHANNEL_9 = 9;

	// DIO Channels
	private final static int DIO_CHANNEL_0 = 0;
	private final static int DIO_CHANNEL_1 = 1;
	private final static int DIO_CHANNEL_2 = 2;
	private final static int DIO_CHANNEL_3 = 3;
	private final static int DIO_CHANNEL_4 = 4;
	private final static int DIO_CHANNEL_5 = 5;
	private final static int DIO_CHANNEL_6 = 6;
	private final static int DIO_CHANNEL_7 = 7;
	private final static int DIO_CHANNEL_8 = 8;
	private final static int DIO_CHANNEL_9 = 9;
	
	
	public static WPI_TalonSRX robotLeftTalon;
	public static WPI_VictorSPX robotLeftVictor;
	public static WPI_TalonSRX robotRightTalon;
	public static WPI_VictorSPX robotRightVictor;
	public static DifferentialDrive myRobot;
	public static SpeedController leftDrive;
	public static SpeedController rightDrive;
	
	public static TalonSRX leftBoxIntake;
	public static TalonSRX rightBoxIntake;
	
	public static TalonSRX dropBoxIntake;
	public static VictorSP lift;
	public static VictorSP climber;
	
	public static RobotUltrasonicAnalog ultraSonic;
	
	public static DigitalInput limitSwitchSlide;
	public static DigitalInput limitDropIntake;
	
	public static Relay wingRelay;
	
	
	public static void init() {

		robotLeftTalon = new WPI_TalonSRX(23);
		robotLeftVictor = new WPI_VictorSPX(21);
		robotLeftVictor.follow(robotLeftTalon,FollowerType.PercentOutput);
		robotRightTalon = new WPI_TalonSRX(22);
		robotRightVictor = new WPI_VictorSPX(20);
		robotLeftVictor.follow(robotLeftTalon,FollowerType.PercentOutput);
		leftDrive = new MultiSpeedController(robotLeftTalon, robotLeftTalon);
		rightDrive = new MultiSpeedController(robotRightTalon, robotRightTalon);
		leftDrive.setInverted(true);
		rightDrive.setInverted(true);
		myRobot = new DifferentialDrive(leftDrive, rightDrive);
		leftBoxIntake = new TalonSRX(12);
		leftBoxIntake.setInverted(true);
		rightBoxIntake = new TalonSRX(13);
		
		dropBoxIntake = new TalonSRX(14);
		lift = new VictorSP(PWM_CHANNEL_4);
		climber = new VictorSP(PWM_CHANNEL_5);
		
		dropBoxIntake.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		dropBoxIntake.getSensorCollection().setQuadraturePosition(0, 10);
		
		ultraSonic = new RobotUltrasonicAnalog(0);
		limitSwitchSlide = new DigitalInput(DIO_CHANNEL_8);
		limitDropIntake = new DigitalInput(DIO_CHANNEL_9);
		
		wingRelay = new Relay(0);

	}
}