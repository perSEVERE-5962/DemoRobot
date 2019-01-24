package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

<<<<<<< HEAD


public class ChangeLedValue extends Subsystem{
    public ChangeLedValue(){
    }

    public void setvalue(String color,int value){
=======
public class ChangeLedValue extends Subsystem {

    public ChangeLedValue(){
        
    }
    public void setValue(String color , int value){
>>>>>>> YashP
        NetworkTableInstance inst =  NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("rgbled");
        NetworkTableEntry entry = table.getEntry(color);
        entry.setValue(value);
    }

<<<<<<< HEAD
    @Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
=======
    protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}
	
>>>>>>> YashP
}