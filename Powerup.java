import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Powerup extends Block
{
	private int starInterval = 5;
    public Powerup(double x, double y, boolean isPit, boolean hasObstacle)
    {
        super(x, y, isPit, hasObstacle);
    }
    public void initStart(){

	}
	public int getStarInterval(){
		return starInterval;
	}
	public void setStarInterval(int starInterval){
		this.starInterval = starInterval;
	}
	public void draw(Graphics g, Ground ground)
    {
		g.setColor(Color.YELLOW);
		g.fillOval((int)getX(), (int)getY(), 50, 50);		//random test drawing of circle
	}

}