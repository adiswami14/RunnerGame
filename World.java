public class World //this class is used only to get position of an object in this world
{
    private int x;
    private int y;
    protected boolean gameOver = false;
    public int gameScore=0;
    public World(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
}
