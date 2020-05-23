import javax.swing.*;
import java.io.*;
import java.awt.*;
public class Game extends JPanel
{
    JFrame frame;
    World world;
    Character player;
    int playerX = 30, playerY = 0;
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
		Ground ground = new Ground(0, 0, 200, false, Color.GREEN);
		g.setColor(ground.getColor());
        g.fillRect(0, frameHeight-ground.getHeight(), frameWidth, frameHeight); //so this goes from bottom to top instead of top to bottom
        player.setY(frameHeight - ground.getHeight());
        g.setColor(Color.RED);
        g.fillRect(player.getX(), player.getY()-40, 40, 40);

	}
    public void instantiateFrame()
    {
        frame = new JFrame();
        world = new World(0,0);
        player = new Character(30, 0);
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