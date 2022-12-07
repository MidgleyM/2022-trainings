package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.util.datalog.DataLog;
import edu.wpi.first.util.datalog.DoubleLogEntry;
import edu.wpi.first.wpilibj.DataLogManager;

public class DriveSubsystem extends SubsystemBase {
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75591;
  private Spark leftSpark = new Spark(0);
  private Spark rightSpark = new Spark(1);
  private DataLog m_robotlog = DataLogManager.getLog();
  private DoubleLogEntry m_leftMasterMotorLog = new DoubleLogEntry(m_robotlog, "/motors/leftSparkSpeed");
  private DoubleLogEntry m_rightMasterMotorLog = new DoubleLogEntry(m_robotlog, "/motors/rightSparkSpeed");
  private final Encoder m_leftEncoder = new Encoder(4, 5);
  private final Encoder m_rightEncoder = new Encoder(6, 7);

  public DriveSubsystem() {
    leftSpark.setInverted(false);
    rightSpark.setInverted(true);
    m_leftEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    m_rightEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();
  }

  public void generateSparkLogEntries(){
    }

  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public int getLeftEncoderCount() {
    return m_leftEncoder.get();
  }

  public int getRightEncoderCount() {
    return m_rightEncoder.get();
  }

  public double getLeftDistanceInch() {
    return m_leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return m_rightEncoder.getDistance();
  }

  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2.0;
  }

  @Override
  public void periodic() {
  }

  public void driveProporinal(double speed, double turn) {
    double leftSpeed = speed - turn;
    double rightSpeed = speed - turn;

    leftSpark.set(leftSpeed);
    rightSpark.set(rightSpeed);

  }

  public void motorStop() {
    leftSpark.set(0);
    rightSpark.set(0);
  }

  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
