package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class DriveAutoCommandGroup extends SequentialCommandGroup{
    public DriveAutoCommandGroup(DriveSubsystem driveSubsystem){
        addCommands(
            new DriveAutoCommand(driveSubsystem, 1000, 1, 0), 
            new DriveAutoCommand(driveSubsystem, 500, 0, 1), 
            new DriveAutoCommand(driveSubsystem, 2000, 1, 0)
        );
    }
}
