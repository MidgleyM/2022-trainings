package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveAutoCommand extends CommandBase{
    long totalTime;
    DriveSubsystem driveSubsystem;
    double speed; double turn;int runTime;  
    public DriveAutoCommand(DriveSubsystem driveSubsystem, int runTime, double speed, double turn){
        this.driveSubsystem = driveSubsystem;
        this.speed = speed;
        this.turn = turn;
        this.runTime = runTime;
    }
    @Override
    public void initialize(){
        totalTime = System.currentTimeMillis() + runTime;
        driveSubsystem.driveProporinal(speed, turn);
    }
    @Override
    public boolean isFinished(){
        return System.currentTimeMillis()>=totalTime;
    }
    @Override
    public void end(boolean interrupted){
        driveSubsystem.motorStop();
    }
}