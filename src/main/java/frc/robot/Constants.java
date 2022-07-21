// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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

    public static final class DriveConstants {
        public static final class FrontLeft {
            // This is the ID of the drive motor
            public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 26;
            // This is the ID of the steer motor
            public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 25;
            // This is the ID of the steer encoder
            public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 3;
            // This is how much the steer encoder is offset from true zero (In our case,
            // zero is facing straight forward)
            public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(307.529);
        }
        public static final class FrontRight {
            public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 28;
            public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 27;
            public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 4;
            public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(187.910);

        }
        public static final class BackLeft {
            public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 24;
            public static final int BACK_LEFT_MODULE_STEER_MOTOR = 23;
            public static final int BACK_LEFT_MODULE_STEER_ENCODER = 2;
            public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(75.586);

        }
        public static final class BackRight {
            public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 22;
            public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 21;
            public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 1;
            public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(56.162) ;

        }

      

        public static final double DRIVETRAIN_TRACKWIDTH_METERS = 0.61665;
        public static final double DRIVETRAIN_WHEELBASE_METERS = 0.61665;
        // public static final double MAX_VELOCITY_METERS_PER_SECOND = 0.1;
        // public static final double MAX_VOLTAGE = 6;
        // public static final double MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND = 5;

    }

    public static final class IOConstants {
        public static double NAVX_RESET_THRESHOLD = 0.2;

        public static final class JoySContants {

            public static final int joyS_ID = 0;
            public static final int TRANSLATION_X_AXIS = 5;
            public static final int TRANSLATION_Y_AXIS = 4;
            public static final int ROTATION_AXIS = 0;



        }
    }
}
