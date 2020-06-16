import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener, MouseInputListener {
    JFrame frame;
    World world;
    Character player;
    Powerup starPower;
    Ground ground = new Ground(0, 0, 200, Color.GREEN, null);
    int playerX = 500, playerY = 0;
    int frameHeight = 600;
    int frameWidth = 1000;
    Timer timer = new Timer(180, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!ground.gameOver)
            {
                ground.keepDrawing();
                world.gameScore++;
            }
        }

    });
    boolean first = false;

    public Game() {
        instantiateFrame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocus(true);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight()); // Created Rectangle for frame
        ground.draw(g);
        player.draw(g, ground);
        starPower.draw(g,ground);
        //enemy.draw(g, ground);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g.setColor(Color.BLACK);
        g.drawString("Score: "+world.gameScore, 425, 50);
        g.setColor(Color.WHITE);
        if (ground.gameOver)
        {
            timer.stop();
            g.drawString("Restart", 425, 200);
        }
        repaint();
    }

    public void instantiateFrame() {
        frame = new JFrame();
        world = new World(0, 0);
        player = new Character(playerX, frameHeight - ground.getHeight());
        starPower = new Powerup(900, 300, false, false);		//testing drawing powerup
        ground.setPlayer(player);
        this.addKeyListener(this);
        this.addMouseListener(this);
        frame.add(this);
        frame.setSize(frameWidth, frameHeight);
        frame.setVisible(true);
        this.requestFocusInWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
    }
    public void restart()
    {
		ground = new Ground(0, 0, 200, Color.GREEN, null);
		world = new World(0, 0);
        player = new Character(playerX, frameHeight - ground.getHeight());
        ground.setPlayer(player);
        timer.start();
		ground.gameOver=false;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if (e.getKeyCode() == 32 && player.completedJump && !player.isFalling) // spacebar
        {
            player.jump();
        }
        else if(e.getKeyCode() == 32 && ground.gameOver)
            restart();
        if(e.getKeyCode() == 10){
			restart();
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(mouseX>=400 && mouseX<=550)
        {
            if(mouseY >= 150 && mouseY<=250)
            {
                restart();
            }
        }

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    public static void main(String[] args)
    {
       Game app = new Game();
    }
}