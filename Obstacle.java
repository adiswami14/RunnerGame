import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Obstacle extends Block
{
	public static int obstacleInterval = 5;
    public Obstacle(double x, double y, boolean isPit, boolean hasObstacle)
    {
		super(x, y, isPit, hasObstacle);
    }
    public void draw(Graphics g)
    {
		if(hasObstacle())
		{
			g.fillRect((int)getX(), (int)getY() - 40, 40, 40);
			//System.out.println("true");
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
}