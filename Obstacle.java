import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Obstacle extends Ground
{
	private int obstacleInterval = 5;
	private boolean create = false;
    public Obstacle(double x, double y)
    {
        super(x, y);
        create=false;
    }
    public void draw(Graphics g, Ground ground)
    {
		g.setColor(Color.MAGENTA);
		g.fillRect((int)getX(), (int)getY() - 40, 40, 40);
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

}