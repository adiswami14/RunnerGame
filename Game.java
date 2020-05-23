import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Game extends JPanel implements KeyListener
{
    JFrame frame;
    World world;
    Character player;
    int playerX = 30, playerY = 0;
    int frameHeight = 600;
    int frameWidth = 1000;
    Ground ground = new Ground(0, 0, 200, false, Color.GREEN);
    public Game()
    {
        instantiateFrame();
    }
    public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0, frame.getWidth(), frame.getHeight());	//Created Rectangle for the ground
		g.setColor(ground.getColor());
        g.fillRect(0, frameHeight-ground.getHeight(), frameWidth, frameHeight); //so this goes from bottom to top instead of top to bottom
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD,40));
        g.drawString("Player X: "+player.getX(), 500, 200);
        g.drawString("Player Y: "+player.getY(), 500, 250);
        g.fillRect(player.getX(), player.getY()-40, 40, 40);

	}
    public void instantiateFrame()
    {
        frame = new JFrame();
        world = new World(0,0);
        player = new Character(30, frameHeight-ground.getHeight());
        this.addKeyListener(this);
        frame.add(this);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        this.requestFocusInWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
            player.jump();
            System.out.println("jump");
            repaint();
        }
		if(e.getKeyCode() == 39)
		{

		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    public static void main(String[] args)
    {
       Game app = new Game();
    }
}