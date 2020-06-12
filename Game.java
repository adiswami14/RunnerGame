import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {
    JFrame frame;
    World world;
    Character player;
    Ground ground = new Ground(0, 0, 200, false, Color.GREEN, null);
    int playerX = 500, playerY = 0;
    int frameHeight = 600;
    int frameWidth = 1000;
    Timer timer = new Timer(180, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            ground.keepDrawing();
            if (!ground.gameOver)
                world.gameScore++;
            // repaint();
        }

    });
    boolean first = false;

    public Game() {
        instantiateFrame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus(true);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight()); // Created Rectangle for frame
        ground.draw(g);
        player.draw(g, ground);
        g.setColor(Color.CYAN);
        g.drawString("Score: "+world.gameScore, 350, 200);
        if (ground.gameOver)
            timer.stop();
        repaint();
    }

    public void instantiateFrame() {
        frame = new JFrame();
        world = new World(0, 0);
        player = new Character(playerX, frameHeight - ground.getHeight());
        ground.setPlayer(player);
        this.addKeyListener(this);
        frame.add(this);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        this.requestFocusInWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == 32 && player.completedJump) // spacebar
        {
            player.jump();
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