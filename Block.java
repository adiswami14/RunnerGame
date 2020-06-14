import java.awt.Color;
import java.awt.*;
public class Block extends World{

    private boolean isPit;
    private boolean hasObstacle;
    public Block(double x, double y, boolean isPit, boolean hasObstacle) {
        super(x, y);
        this.isPit = isPit;
        this.hasObstacle = hasObstacle;
    }
    public void draw(Graphics g, Ground ground)
    {
        g.fillRect((int)getX(), (int)getY(), 1000/10, ground.getHeight());
        if(hasObstacle())
        {
            Obstacle obstacle = new Obstacle(getX(), getY(), isPit, hasObstacle);
            obstacle.draw(g, ground);
            obstacle.intersect(ground.getPlayer());
        }
    }
    public boolean hasObstacle(){return hasObstacle;}
    public boolean isPit(){return isPit;}
    public void setObstacle(boolean hasObstacle){this.hasObstacle=hasObstacle;}
    public void setPit(boolean isPit){this.isPit = isPit;}
    
}