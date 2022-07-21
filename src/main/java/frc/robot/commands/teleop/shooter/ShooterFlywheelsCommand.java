// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop.shooter;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class ShooterFlywheelsCommand extends CommandBase {
  /** Creates a new ShooterFlywheelsCommand. */
  private ShooterSubsystem shooterSubsystem;
  private Supplier<Double> shooterFlywheel_1_Axis;

  public ShooterFlywheelsCommand(ShooterSubsystem shooterSubsystem, Supplier<Double> shooterFlywheel_1_Axis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    this.shooterFlywheel_1_Axis = shooterFlywheel_1_Axis;

    addRequirements(this.shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double flywheelValue = this.shooterFlywheel_1_Axis.get();
    flywheelValue = (Math.abs(flywheelValue) < ShooterConstants.shooterDeadband) ? 0 : flywheelValue;

    this.shooterSubsystem.flywheelShoot(flywheelValue);

    this.shooterSubsystem.setHoodAngle(this.shooterSubsystem.currentHoodAngle);

    this.shooterSubsystem.setTurretAngle(this.shooterSubsystem.currentTurretAngle);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.shooterSubsystem.setHoodAngle(0.0);
    this.shooterSubsystem.setTurretAngle(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
