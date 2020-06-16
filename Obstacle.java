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
    public void draw(Graphics g, Ground ground)
    {
		int[] xpoints = {(int)getX(),(int) getX()+50, (int)getX()+100};
		int[] ypoints = {(int)getY(), (int)getY()-40, (int)getY()};
		g.fillPolygon(xpoints, ypoints, 3);			//draws triangle for the obstacle
		g.setColor(Color.BLACK);
		g.drawPolygon(xpoints, ypoints, 3);
		g.setColor(ground.getColor());
		//intersect(ground.getPlayer());
	}
	public boolean intersect(Character player){
		return (player.getX() == getX() && player.getY() == getY());
	}
	public int getObstacleInterval(){
		return obstacleInterval;
	}
	public void setObstacleInterval(int interval){
		obstacleInterval = interval;
	}
}