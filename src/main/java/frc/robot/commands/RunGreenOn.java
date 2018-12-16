package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;

public class RunGreenOn extends Command{
  
 
    protected void initialize(){
        NetworkTableInstance inst =  NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("rgbled");
        NetworkTableEntry entry = table.getEntry("green");
        entry.setValue(255);
        Robot.oi.greenOn = true;
        
    }

    protected void execute(){
    }
    protected boolean isFinished(){
        return (Robot.oi.greenOn == false);
    }
    protected void end(){

    }
    protected void interrupted(){

    }

}