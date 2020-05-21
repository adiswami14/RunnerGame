import javax.swing.*;
import java.io.*;
public class Game extends JPanel
{
    JFrame frame;
    World world;
    public Game()
    {
        instantiateFrame();
    }
    public void instantiateFrame()
    {
        frame = new JFrame();
        world = new World();
        frame.add(this);
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
       Game app = new Game(); 
    }
}