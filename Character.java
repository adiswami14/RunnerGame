import java.awt.event.*;
import java.io.*;
import java.io.Console;
import javax.swing.Timer;

public class Character extends World {
    private int speed = 2; // rate of ground movement beneath character
    public boolean isJumping = false;
    public Character(int x, int y) {
        super(x, y);
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void jump() {
        isJumping = true;        
    }
}