// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.ShooterConstants.FlywheelConstants;
import frc.robot.Constants.ShooterConstants.HoodConstants;
import frc.robot.Constants.ShooterConstants.TurretConstants;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX talonFlywheels;
  private final TalonFX talonHood;
  private final TalonFX talonTurret;

  public double currentHoodAngle = 0;
  public double currentTurretAngle = 0;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    this.talonFlywheels = new TalonFX(FlywheelConstants.flywheelsPort);
    this.talonHood = new TalonFX(HoodConstants.hoodPort);
    this.talonTurret = new TalonFX(TurretConstants.turretPort);

    // Factory Default
    this.talonFlywheels.configFactoryDefault();
    this.talonHood.configFactoryDefault();
    this.talonTurret.configFactoryDefault();

    this.talonFlywheels.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
        ShooterConstants.kPIDLoopIdx,
        ShooterConstants.kTimeoutMs);
    this.talonHood.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
        ShooterConstants.kPIDLoopIdx,
        ShooterConstants.kTimeoutMs);
    this.talonTurret.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,
        ShooterConstants.kPIDLoopIdx,
        ShooterConstants.kTimeoutMs);

    /* Ensure sensor is positive when output is positive */
    this.talonFlywheels.setSensorPhase(ShooterConstants.kSensorPhase);
    this.talonHood.setSensorPhase(ShooterConstants.kSensorPhase);
    this.talonTurret.setSensorPhase(ShooterConstants.kSensorPhase);

    /**
     * Set based on what direction you want forward/positive to be.
     * This does not affect sensor phase.
     */
    this.talonFlywheels.setInverted(ShooterConstants.kMotorInvert);
    this.talonHood.setInverted(ShooterConstants.kMotorInvert);
    this.talonTurret.setInverted(ShooterConstants.kMotorInvert);

    /* Config the peak and nominal outputs, 12V means full */
    this.talonFlywheels.configNominalOutputForward(0,
        ShooterConstants.kTimeoutMs);
    this.talonFlywheels.configNominalOutputReverse(0,
        ShooterConstants.kTimeoutMs);
    this.talonFlywheels.configPeakOutputForward(1, ShooterConstants.kTimeoutMs);
    this.talonFlywheels.configPeakOutputReverse(-1, ShooterConstants.kTimeoutMs);
    this.talonHood.configNominalOutputForward(0, ShooterConstants.kTimeoutMs);
    this.talonHood.configNominalOutputReverse(0, ShooterConstants.kTimeoutMs);
    this.talonHood.configPeakOutputForward(0.05, ShooterConstants.kTimeoutMs);
    this.talonHood.configPeakOutputReverse(-0.05, ShooterConstants.kTimeoutMs);
    this.talonTurret.configNominalOutputForward(0, ShooterConstants.kTimeoutMs);
    this.talonTurret.configNominalOutputReverse(0, ShooterConstants.kTimeoutMs);
    this.talonTurret.configPeakOutputForward(0.75, ShooterConstants.kTimeoutMs);
    this.talonTurret.configPeakOutputReverse(-0.75, ShooterConstants.kTimeoutMs);

    /**
     * Config the allowable closed-loop error, Closed-Loop output will be
     * neutral within this range. See Table in Section 17.2.1 for native
     * units per rotation.
     */
    this.talonFlywheels.configAllowableClosedloopError(0,
        ShooterConstants.kPIDLoopIdx, ShooterConstants.kTimeoutMs);
    this.talonHood.configAllowableClosedloopError(0,
        ShooterConstants.kPIDLoopIdx, ShooterConstants.kTimeoutMs);
    this.talonTurret.configAllowableClosedloopError(0, ShooterConstants.kPIDLoopIdx, ShooterConstants.kTimeoutMs);

    /* Config Position Closed Loop gains in slot0, tsypically kF stays zero. */
    this.talonFlywheels.config_kF(ShooterConstants.kPIDLoopIdx,
        FlywheelConstants.kGains.kF,
        ShooterConstants.kTimeoutMs);
    this.talonFlywheels.config_kP(ShooterConstants.kPIDLoopIdx,
        FlywheelConstants.kGains.kP,
        ShooterConstants.kTimeoutMs);
    this.talonFlywheels.config_kI(ShooterConstants.kPIDLoopIdx,
        FlywheelConstants.kGains.kI,
        ShooterConstants.kTimeoutMs);
    this.talonFlywheels.config_kD(ShooterConstants.kPIDLoopIdx,
        FlywheelConstants.kGains.kD,
        ShooterConstants.kTimeoutMs);
    this.talonHood.config_kF(ShooterConstants.kPIDLoopIdx,
        HoodConstants.kGains1.kF, ShooterConstants.kTimeoutMs);
    this.talonHood.config_kP(ShooterConstants.kPIDLoopIdx,
        HoodConstants.kGains1.kP, ShooterConstants.kTimeoutMs);
    this.talonHood.config_kI(ShooterConstants.kPIDLoopIdx,
        HoodConstants.kGains1.kI, ShooterConstants.kTimeoutMs);
    this.talonHood.config_kD(ShooterConstants.kPIDLoopIdx,
        HoodConstants.kGains1.kD, ShooterConstants.kTimeoutMs);
    this.talonHood.setSelectedSensorPosition(0);

    this.talonTurret.config_kF(ShooterConstants.kPIDLoopIdx, TurretConstants.kGains2.kF, ShooterConstants.kTimeoutMs);
    this.talonTurret.config_kP(ShooterConstants.kPIDLoopIdx, TurretConstants.kGains2.kP, ShooterConstants.kTimeoutMs);
    this.talonTurret.config_kI(ShooterConstants.kPIDLoopIdx, TurretConstants.kGains2.kI, ShooterConstants.kTimeoutMs);
    this.talonTurret.config_kD(ShooterConstants.kPIDLoopIdx, TurretConstants.kGains2.kD, ShooterConstants.kTimeoutMs);

  }

  public void initializeTurretAngle() {
    this.currentTurretAngle = this.talonTurret.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("HOOD Angle", this.currentHoodAngle);
    SmartDashboard.putNumber("TURRET Angle", this.currentTurretAngle);
  }

  public void flywheelShoot(double speed) {
    this.talonFlywheels.set(TalonFXControlMode.PercentOutput, speed *
        FlywheelConstants.flywheelMaxSpeed);
  }

  public void setHoodUpward(boolean is_up) {
    if (is_up == false)
      return;
    this.currentHoodAngle += HoodConstants.angularPositionIncrement(1);
    if (this.currentHoodAngle >= HoodConstants.angularPositionIncrement(15))
      this.currentHoodAngle = HoodConstants.angularPositionIncrement(15);
    this.talonHood.set(TalonFXControlMode.Position, this.currentHoodAngle);
  }

  public void setHoodDownward(boolean is_down) {
    if (is_down == false)
      return;
    this.currentHoodAngle -= HoodConstants.angularPositionIncrement(1);
    if (this.currentHoodAngle <= 0)
      this.currentHoodAngle = 0;
    this.talonHood.set(TalonFXControlMode.Position, this.currentHoodAngle);
  }

  public void setTurretUpward(boolean is_up) {
    if (is_up == false)
      return;
    this.currentTurretAngle += TurretConstants.angularPositionIncrement(10);
    if (this.currentTurretAngle >= TurretConstants.angularPositionIncrement(270))
      this.currentTurretAngle = TurretConstants.angularPositionIncrement(270);
    this.talonTurret.set(TalonFXControlMode.Position, this.currentTurretAngle);
  }

  public void setTurretDownward(boolean is_down) {
    if (is_down == false)
      return;
    this.currentTurretAngle -= TurretConstants.angularPositionIncrement(10);
    if (this.currentTurretAngle <= 0)
      this.currentTurretAngle = 0;
    this.talonTurret.set(TalonFXControlMode.Position, this.currentTurretAngle);
  }

  public void setHoodAngle(double angle) {
    this.talonHood.set(TalonFXControlMode.Position, this.currentHoodAngle);
  }

  public void setTurretAngle(double currentTurretAngle) {
    this.talonTurret.set(TalonFXControlMode.Position, this.currentTurretAngle);
  }
}
