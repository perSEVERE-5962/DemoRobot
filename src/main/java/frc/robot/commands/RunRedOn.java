package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;
public class RunRedOn extends Command{
  
 
    public void initialize(){
        ChangeLedValue rgbLed = new ChangeLedValue();
        rgbLed.setValue("red" , 255);
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