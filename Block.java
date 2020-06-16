import java.awt.*;
public class Block extends World{			//rectangles that make up the ground (may have a pit or obstacle)

    private boolean isPit;
    private boolean hasObstacle;
    private boolean hasStar;
    public Block(double x, double y, boolean isPit, boolean hasObstacle) {
        super(x, y);
        this.isPit = isPit;
        this.hasObstacle = hasObstacle;
    }
    public void draw(Graphics g, Ground ground)
    {
        g.fillRect((int)getX(), (int)getY(), 1000/10, ground.getHeight());
    }
    public boolean hasObstacle(){return hasObstacle;}
    public boolean isPit(){return isPit;}
    public boolean hasStar(){return hasStar;}
    public void setObstacle(boolean hasObstacle){this.hasObstacle=hasObstacle;}
    public void setPit(boolean isPit){this.isPit = isPit;}
    public void setStar(boolean hasStar){this.hasStar = hasStar;}
}