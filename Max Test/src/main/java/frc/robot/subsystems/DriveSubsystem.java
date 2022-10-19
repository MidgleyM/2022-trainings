package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase{
    WPI_TalonFX leftFalconMaster;
    WPI_TalonFX[] leftFalconSlaves;
    WPI_TalonFX rightFalconMaster;
    WPI_TalonFX[] rightFalconSlaves;
  public DriveSubsystem() {
       leftFalconMaster = new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_LEFT_1);
       leftFalconSlaves = new WPI_TalonFX[]{
            new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_LEFT_2),
            new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_LEFT_3)};
            leftFalconMaster.setNeutralMode(NeutralMode.Brake);
            leftFalconMaster.setInverted(false);

     rightFalconMaster = new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_RIGHT_1);
     rightFalconSlaves = new WPI_TalonFX[]{
        new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_RIGHT_2),
        new WPI_TalonFX(Constants.CAN_ID.DRIVE_MOTOR_RIGHT_3)};
        rightFalconMaster.setNeutralMode(NeutralMode.Brake);
        rightFalconMaster.setInverted(true);
    for (WPI_TalonFX slave: leftFalconSlaves){
        slave.follow(leftFalconMaster, FollowerType.PercentOutput);
        slave.setNeutralMode(NeutralMode.Brake);
        slave.setInverted(false);
    }
    for (WPI_TalonFX slave: rightFalconSlaves){
        slave.follow(rightFalconMaster, FollowerType.PercentOutput);
        slave.setNeutralMode(NeutralMode.Brake);
        slave.setInverted(true);
    }
    }

  @Override
  public void periodic() {
  }
  public void driveProporinal(double speed, double turn){
      double leftSpeed = speed - turn;
      double rightSpeed = speed + turn;
      leftFalconMaster.set(leftSpeed);
      rightFalconMaster.set(rightSpeed);
  }
  public void motorStop(){
      leftFalconMaster.set(0);
      rightFalconMaster.set(0);
  }
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
