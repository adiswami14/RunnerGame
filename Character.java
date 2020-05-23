import java.awt.event.*;
public class Character extends World implements KeyListener
{

    private int speed = 2; //rate of ground movement beneath character
    private int jumpHeight = 30; //height that character jumps when jump method is called
    public Character(int x, int y)
    {
        super(x, y);
    }
    public int getJumpHeight()
    {
        return jumpHeight;
    }
    public void setJumpHeight(int jumpHeight)
    {
        this.jumpHeight = jumpHeight;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void jump()
    {
        setY(getY()+jumpHeight);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode() == 32) //spacebar
        {
            jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}