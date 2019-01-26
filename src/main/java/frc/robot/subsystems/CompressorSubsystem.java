/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Preferences;

/**
 * Add your docs here.
 */
public class CompressorSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  Preferences prefs;
  Compressor compressor;

  @Override
  public void initDefaultCommand() {
    compressor = new Compressor(0);

		prefs = Preferences.getInstance();
		compressor.setClosedLoopControl(prefs.getBoolean("RunCompressor", false));
  }

  public void runCompressor() {
		compressor.setClosedLoopControl(prefs.getBoolean("RunCompressor", false));
  }

  public void updateSmartDashboard() {
    SmartDashboard.putBoolean("Compressor Status", compressor.enabled());
    SmartDashboard.putBoolean("Pressure Switch", compressor.getPressureSwitchValue());
    SmartDashboard.putNumber("Compressor Current", compressor.getCompressorCurrent());
  }
}