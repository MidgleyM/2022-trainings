package frc.robot.subsystems;

public class Square{
    //member variables
    int length;
    //constructor
    public Square(int length){
        this.length=length;
    }
    //member methods
    public int getArea() {
        return length*length;
    }
}