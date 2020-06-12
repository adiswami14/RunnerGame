import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;
import java.awt.*;
public class Enemy extends World
{
	private int speed = -5;
    public Enemy(double x, double y)
    {
        super(x, y);
    }
    public void draw(Graphics g, Ground ground)
    {
		g.setColor(Color.MAGENTA);
		g.fillRect((int)getX(), (int)getY() - 40, 40, 40);
	}
	public void moveLeft(){
		setX(getX()+speed);
	}


}