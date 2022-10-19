package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveAutoCommand extends CommandBase{
    DriveSubsystem driveSubsystem;
    int timeMS; double speed; double turn;
    public DriveAutoCommand(DriveSubsystem driveSubsystem, int timeMS, double speed, double turn){
        this.driveSubsystem = driveSubsystem;
        this.speed = speed;
        this.turn = turn;
    }
    @Override
    public void execute(){
        if(timeMS>= 0){
            driveSubsystem.driveProporinal(speed, turn);
        }
    }
    @Override
    public boolean isFinished(){
        timeMS-=20;
        return false;
    }
    @Override
    public void end(boolean interrupted){
    }
}