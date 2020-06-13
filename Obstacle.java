import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Obstacle extends Ground
{
	public static int obstacleInterval = 5;
	private boolean create = false;
	private boolean isJumping = false;
	private boolean completedJump = true;
    public Obstacle(double x, double y)
    {
        super(x, y);
        create=false;
    }
    public void draw(Graphics g)
    {
		g.setColor(Color.MAGENTA);
		g.fillRect((int)getX(), (int)getY() - 40, 40, 40);
		move();
		if(getY()<=200)
            isJumping = false;
        if(isJumping)
        {
            setY(getY()-3);
            //setX(getX()+getJumpHeight()/4);
        }
        else if(!isJumping && getY()<600 - getHeight() && !completedJump)
        {
            setY(getY()+3);
            //setX(getX()+getJumpHeight()/4);
        }
        if(getY()>=600-getHeight() && !completedJump)
        {
            setY(600-getHeight());
            completedJump=true;
		}
	}
	public void intersect(Character player){
	}
	public int getObstacleInterval(){
		return obstacleInterval;
	}
	public void setObstacleInterval(int interval){
		obstacleInterval = interval;
	}
	public void setCreate(){
		create = true;
	}
	public boolean getCreate(){
		return this.create;
	}
	public void move()
	{
		setX(getX()-0.5);
		if(seePit())
			jump();
	}
	public void jump()
	{
		isJumping=true;
		completedJump=false;
	}
	public boolean seePit()
	{
		return true;
	}

}