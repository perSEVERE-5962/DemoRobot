package frc.robot.commands;

import frc.robot.Robot;

<<<<<<< refs/remotes/origin/2019

=======
>>>>>>> Commit the Message
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

public class RunGreenOn extends Command{
<<<<<<< refs/remotes/origin/2019
    protected void initialize(){    
    }

    protected void execute(){
        NetworkTableInstance inst =  NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("rgbled");
        NetworkTableEntry entry = table.getEntry("green");
        entry.setValue(100);
        Robot.oi.greenOn = true;
=======
  
 
    protected void initialize(){
        NetworkTableInstance inst =  NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("rgbled");
        NetworkTableEntry entry = table.getEntry("green");
        entry.setValue(255);
        Robot.oi.greenOn = true;
        
    }

    protected void execute(){
>>>>>>> Commit the Message
    }
    protected boolean isFinished(){
        return (Robot.oi.greenOn == false);
    }
    protected void end(){

    }
    protected void interrupted(){

    }

}