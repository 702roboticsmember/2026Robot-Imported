// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.wpilib.command2.SubsystemBase;

import com.limelightvision.Limelight;
import frc.robot.Constants;


public class LimelightSubsystem extends SubsystemBase {
  Limelight limelight = new Limelight(Constants.limelightConstants.limelightTurret);
  /** Creates a new LimelightSubsystem. */
  public LimelightSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
