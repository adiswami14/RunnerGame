import java.awt.event.*;
import java.io.*;
import java.io.Console;
public class Character extends World
{
    private int speed = 2; //rate of ground movement beneath character
    private int jumpHeight = 30; //height that character jumps when jump method is called
    public Character(int x, int y)
    {
        super(x, y);
    }
    public int getJumpHeight()
    {
        return jumpHeight;
    }
    public void setJumpHeight(int jumpHeight)
    {
        this.jumpHeight = jumpHeight;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void jump()
    {
        setY(getY()-jumpHeight);
    }
}