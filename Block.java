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
        g.fillRect((int)getX(), 600-ground.getHeight(), 1000/10, ground.getHeight());
        new Obstacle(960-getX(), getY(), isPit, hasObstacle).draw(g);
    }
    public boolean hasObstacle(){return hasObstacle;}
    public boolean isPit(){return isPit;}
    public void setObstacle(boolean hasObstacle){this.hasObstacle=hasObstacle;}
    public void setPit(boolean isPit){this.isPit = isPit;}
    
}