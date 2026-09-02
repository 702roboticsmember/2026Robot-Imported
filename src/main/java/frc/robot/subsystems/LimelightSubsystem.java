// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.wpilib.command2.SubsystemBase;
import org.wpilib.math.geometry.Pose2d;

import com.limelightvision.Limelight;
import com.limelightvision.Limelight.FiducialTarget;
import com.limelightvision.Limelight.IMUData;
import com.limelightvision.Limelight.LimelightResults;

import frc.robot.Constants;


public class LimelightSubsystem extends SubsystemBase {
  Limelight limelight = new Limelight(Constants.limelightConstants.limelightTurret);
  /** Creates a new LimelightSubsystem. */
  public LimelightSubsystem() {

  }

  public LimelightResults getResults() {
    return limelight.getLatestResults();
  }

  public FiducialTarget[] getTargets() {
    return getResults().fiducialTargets;
  }
  public FiducialTarget getTarget() {
    return getTargets()[0];
  }
  public Pose2d getTargetPoseCameraSpace() {
    var targets = getTarget();
    return Limelight.toPose2D(targets.targetPoseCameraSpace);
  }
  public Pose2d getTargetPoseRobotSpace() {
    var targets = getTarget();
    return Limelight.toPose2D(targets.targetPoseRobotSpace);
  }
  public Pose2d getCameraPoseTargetSpace() {
    var targets = getTarget();
    return Limelight.toPose2D(targets.cameraPoseTargetSpace);
  }
  public IMUData getIMUData() {
    return getResults().imu;
  }

  public boolean isTargetAvailable() {
    return limelight.getTargetCount() > 0;
  }
  public double getTXDegrees() {
    return getTarget().txDegrees;
  }

  public double getIMUYaw() {
    return getIMUData().yaw;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
