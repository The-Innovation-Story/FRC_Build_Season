// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.util.Gains;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class ShooterConstants {

        public static class HoodConstants {
            public static int hoodPort = 7;
            public static double hoodGearRatio = 107520;
            public static Gains kGains1 = new Gains(0.3, 0, 0, 0, 0, 1.0);

            public static double angularPositionIncrement(double angle) {
                return (angle / 360) * HoodConstants.hoodGearRatio;
            }
        }

        public static class FlywheelConstants {
            public static int flywheelsPort = 4;
            public static double flywheelMaxSpeed = 0.2;
            public static Gains kGains = new Gains(0.09, 0.000, 0.00, 0.046, 0, 1.0);
        }

        public static final int kPIDLoopIdx = 0;
        public static final int kTimeoutMs = 30;
        public static final boolean kSensorPhase = true;

        public static double shooterDeadband = 0.15;

        public static boolean kMotorInvert = false;

        /**
         * Gains used in Positon Closed Loop, to be adjusted accordingly
         * Gains(kp, ki, kd, kf, izone, peak output);
         */

        public static Gains kGains3 = new Gains(0.3, 0.00, 0.00, 0.00, 0, 1.0);
        public static Gains kGains2 = new Gains(0.2, 0.0, 0.0, 0.0, 0, 1.0);

    }

    public static class JoystickContants {
        public static int joySPort = 0;
    }
}
