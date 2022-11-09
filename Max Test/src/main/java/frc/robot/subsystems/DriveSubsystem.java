package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75591;
  Spark leftSpark;
  Spark rightSpark;
  private final Encoder m_leftEncoder = new Encoder(4, 5);
  private final Encoder m_rightEncoder = new Encoder(6, 7);
  public DriveSubsystem() {
    leftSpark = new Spark(0);
      //leftSpark.setNeutralMode(NeutralMode.Brake);
      leftSpark.setInverted(false);
    rightSpark = new Spark(1);
      //rightSpark.setNeutralMode(NeutralMode.Brake);
      rightSpark.setInverted(true);
      m_leftEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
      m_rightEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();
    }

    public void resetEncoders() {
      m_leftEncoder.reset();
      m_rightEncoder.reset();
    }
  @Override
  public void periodic() {
  }
  public void driveProporinal(double speed, double turn){
      double leftSpeed = speed - turn;
      double rightSpeed = speed + turn;
      leftSpark.set(leftSpeed);
      rightSpark.set(rightSpeed);
  }
  public void motorStop(){
      leftSpark.set(0);
      rightSpark.set(0);
  }
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
