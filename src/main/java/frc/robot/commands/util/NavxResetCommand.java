// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.util;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.IOConstants;
import frc.robot.subsystems.drive.SwerveDriveSubsystem;

public class NavxResetCommand extends CommandBase {
  private SwerveDriveSubsystem swerveDriveSubsystem;

  /** Creates a new NavxResetCommand. */
  public NavxResetCommand(SwerveDriveSubsystem swerveDriveSubsystem) {
    this.swerveDriveSubsystem = swerveDriveSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.swerveDriveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.swerveDriveSubsystem.zeroGyroscope();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.swerveDriveSubsystem.resetPose();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(this.swerveDriveSubsystem.getCurrentYaw()) < IOConstants.NAVX_RESET_THRESHOLD;
  }
}
