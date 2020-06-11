public class World //this class is used only to get position of an object in this world
{
    private double x;
    private double y;
    protected boolean gameOver = false;
    public int gameScore=0;
    public World(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public void setX(double x)
    {
        this.x = x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
}
