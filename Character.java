import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Character extends World {
    private int speed = 2; // rate of ground movement beneath character
    public boolean isJumping = false;
    private double jumpHeight = 3;
    public boolean completedJump = true;
    public boolean isFalling = false;
    private int health = 100;
    public Character(double x, double y) {
        super(x, y);
    }
    public int getHealth(){return health;}
    public void setHealth(int health){this.health = health;}
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
    public void fall()
    {
        isFalling = true;
    }
    public boolean isInRangeOfPit(double source, double target, double range)
    {
        return (source >= target-range && source <=target+range -40 && completedJump);
    }
    public void draw(Graphics g, Ground ground)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g.fillRect((int)getX(), (int)getY() - 40, 40, 40);
        g.setColor(new Color(255 - 255*(getHealth()/100), 255*(getHealth()/100), 0));
        g.fillRect((int)getX(), (int)getY()-65, 40, 15);
        g.setColor(Color.GRAY);
        g.drawRect((int)getX(), (int)getY()-65, 40, 15);
        if(getY()<=200)
            isJumping = false;
        if(isJumping)
        {
            setY(getY()-(getJumpHeight()));
        }
        else if(!isJumping && getY()<600 - ground.getHeight())
        {
            setY(getY()+getJumpHeight());
        }
        if(isFalling)
        {
            setY(getY()+getJumpHeight());
        }
        if(ground.gameOver)
        {
            fall();
        }
        if(getY()>=600-ground.getHeight() && !completedJump)
        {
            setY(600-ground.getHeight());
            completedJump=true;
        }
    }
}