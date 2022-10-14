// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import javax.sound.sampled.SourceDataLine;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.subsystems.Square.*;
/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {
  private Main() {}

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
    
  /*System.out.println("abc");
  int abc=1;
  int cba=abc*3;
  System.out.println(abc+abc*cba);
  Square square1=new Square(cba);
  Square square2=new Square(4);
  System.out.println(square1.getArea());
  System.out.println(square2.getArea());
  int[] nums=new int[5];
  for(int j=0;j<=4;j+=1){
    nums[j]=j;
    System.out.println(nums[j]);
  }
  Square[] squares=new Square[5];
  for(int j=1;j<=5;j+=1){
    squares[j-1]=new Square(j);
  }
  for(int j=0;j<=4;j+=1){
    System.out.println(squares[j].getArea());  
  }
  }*/
}}
