package frc.robot.util;

public class Gains {
    public double kP;
    public double kI;
    public double kD;
    public double kF;
    public int kIzone;
    public double kPeakOutput;

    public Gains(double _kP, double _kI, double _kD, double _kF, int _kIzone, double _kPeakOutput) {
        kP = _kP;
        kI = _kI;
        kD = _kD;
        kF = _kF;
        kIzone = _kIzone;
        kPeakOutput = _kPeakOutput;
    }
}
