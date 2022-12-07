package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveProportionalCommand extends CommandBase{
    XboxController driverXboxController;
    DriveSubsystem driveSubsystem;
    public DriveProportionalCommand(XboxController driverXboxController, DriveSubsystem driveSubsystem) {
        this.driverXboxController = driverXboxController;
        this.driveSubsystem = driveSubsystem;

        addRequirements(driveSubsystem);
    }
    @Override
    public void execute(){
        driveSubsystem.driveProporinal(driverXboxController.getLeftY(), driverXboxController.getRightX());
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
