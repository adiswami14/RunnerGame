import javax.swing.*;
import java.io.*;
import java.awt.*;
public class Game extends JPanel
{
    JFrame frame;
    World world;
    int frameHeight = 600;
    int frameWidth = 1000;
    public Game()
    {
        instantiateFrame();
    }
    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		g.setColor(Color.BLACK);

		g.fillRect(0,0, frame.getWidth(), frame.getHeight());	//Created Rectangle for the ground
		Ground ground = new Ground(200, false, Color.GREEN);
		g.setColor(ground.getColor());
		g.fillRect(0, frameHeight-ground.getHeight(), frameWidth, frameHeight);

	}
    public void instantiateFrame()
    {
        frame = new JFrame();
        world = new World();
        frame.add(this);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
       Game app = new Game();
    }
}