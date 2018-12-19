package frc.robot.commands;

import frc.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.ChangeLedValue;

public class RunGreenOn extends Command{
  private int value=255;
public void setValue(int value){
    this.value=value;
}
    protected void initialize(){    
    }

    protected void execute(){
       ChangeLedValue led=new ChangeLedValue();
       led.setvalue("green",255);
        Robot.oi.greenOn = true;
    }
    protected boolean isFinished(){
        return (Robot.oi.greenOn == false);
    }
    protected void end(){

    }
    protected void interrupted(){

    }

}