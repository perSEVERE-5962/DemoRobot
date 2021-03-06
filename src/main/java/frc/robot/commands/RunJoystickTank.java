package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.JoystickThrottle;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RunJoystickTank extends Command {

	//private JoystickThrottle throttle = new JoystickThrottle();
	public  RunJoystickTank() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.myRobot.setMaxOutput ((Robot.getRobotSpeed()));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {  
    	Robot.drive.joystickTank();
    	JoystickThrottle.Speed();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

	
	
	
	
	
	


