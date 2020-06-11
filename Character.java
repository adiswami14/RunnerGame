import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Character extends World {
    private int speed = 2; // rate of ground movement beneath character
    public boolean isJumping = false;
    private int jumpHeight = 2;
    public Character(int x, int y) {
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
    public void jump() {
        isJumping = true;        
    }
    public boolean isInRange(int source, int target, int range)
    {
        return (source >= target-range && source <=target+range);
    }
    public void draw(Graphics g, Ground ground)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        //g.drawString("Player X: " + getX(), 500, 200);
        //g.drawString("Player Y: " + getY(), 500, 250);
        g.fillRect(getX(), getY() - 40, 40, 40);
        if(isJumping)
        {
            setY(getY()-getJumpHeight());
        }
        else if(!isJumping && getY()<600 - ground.getHeight())
            setY(getY()+getJumpHeight());
    }
}