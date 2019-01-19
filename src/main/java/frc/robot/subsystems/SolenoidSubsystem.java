/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
/**
 * Add your docs here.
 */
public class SolenoidSubsystem extends Subsystem {
	static Solenoid s0 = new Solenoid(0);
	static Solenoid s1 = new Solenoid(1);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void activateZero(){
    s1.set(false);
    s0.set(true);
  }
  
  
  public void activateOne(){
    s0.set(false);
    s1.set(true);
  }
}
