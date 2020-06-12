import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Character extends World {
    private int speed = 2; // rate of ground movement beneath character
    public boolean isJumping = false;
    private double jumpHeight = 5;
    private double jumpRate = 0.2;
    public boolean completedJump = true;
    public Character(int x, int y) {
        super(x, y);
    }
    public double getJumpHeight()
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
    public void jump() {
        isJumping = true;  
        completedJump=false;      
    }
    public boolean isInRange(double source, double target, double range)
    {
        return (source >= target-range && source <=target+range);
    }
    public void draw(Graphics g, Ground ground)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        //g.drawString("Player X: " + getX(), 500, 200);
        //g.drawString("Player Y: " + getY(), 500, 250);
        g.fillRect((int)getX(), (int)getY() - 40, 40, 40);
        if(getY()<=250)
            isJumping = false;
        if(isJumping)
        {
            setY(getY()-(getJumpHeight()));
            //setX(getX()+getJumpHeight()/4);
        }
        else if(!isJumping && getY()<600 - ground.getHeight())
        {
            setY(getY()+getJumpHeight());
            //setX(getX()+getJumpHeight()/4);
        }
        if(getY()>=600-ground.getHeight() && !completedJump)
        {
            setY(600-ground.getHeight());
            completedJump=true;
        }
    }
}