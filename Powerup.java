import java.awt.*;
public class Powerup extends Block
{
	public static int starInterval = 50;
	public static int starTime = 30;
    public Powerup(double x, double y, boolean isPit, boolean hasObstacle)
    {
        super(x, y, isPit, hasObstacle);
	}
	public int getStarInterval(){
		return starInterval;
	}
	public void setStarInterval(int starInterval){		//dont rlly need bc public static variable
		Powerup.starInterval = starInterval;
	}
	public void draw(Graphics g, Ground ground)
    {
		g.setColor(Color.YELLOW);
		g.fillOval((int)getX(), (int)getY(), 50, 50);		//random test drawing of circle
		g.setColor(ground.getColor());
	}
	public boolean intersect(Character player){
		return (player.getX() == getX() && player.getY() == getY());
	}

}