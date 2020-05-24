import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel implements KeyListener {
    JFrame frame;
    World world;
    Character player;
    Ground ground = new Ground(0, 0, 200, false, Color.GREEN);;
    int playerX = 30, playerY = 0;
    int frameHeight = 600;
    int frameWidth = 1000;
    int pitInterval = 5; //will change everytime a pitFall shows up
    int countRight =0; //number of times the right arrow has been clicked
	boolean first = false;
    public Game() {
        instantiateFrame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight()); // Created Rectangle for frame

      	g.setColor(ground.getColor());
		int count =0;
		for(int x=0; x<frame.getWidth(); x++){
			if(x%100 == 0){ //evenly divides width into 10 rectangles
				if(ground.getPitPosition().get(count) == false){
					g.fillRect(x, frameHeight-ground.getHeight(), frameWidth/10, ground.getHeight()); //so this goes from bottom to top instead of top to bottom

					/*
					if(count%2==0){							//alternates color to see each rectangle
						ground.setColor(Color.YELLOW);
						g.setColor(ground.getColor());
					}
					else{
						ground.setColor(Color.GREEN);
						g.setColor(ground.getColor());
					}*/

				}
				count++;
			}
		}

        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g.drawString("Player X: " + player.getX(), 500, 200);
        g.drawString("Player Y: " + player.getY(), 500, 250);
        g.fillRect(player.getX(), player.getY() - 40, 40, 40);
        if(player.isJumping)
        {
            player.setY(player.getY()-player.getJumpHeight());
        }
        else if(!player.isJumping && player.getY()<frameHeight - ground.getHeight())
            player.setY(player.getY()+player.getJumpHeight());
        repaint();
    }

    public void instantiateFrame() {
        frame = new JFrame();
        world = new World(0, 0);
        player = new Character(30, frameHeight - ground.getHeight());
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
        if (e.getKeyCode() == 32) // spacebar
        {
            player.jump();
            new Thread(new thread()).start();
        }
        if (e.getKeyCode() == 39) // right
        {
			countRight++;
			if(countRight%pitInterval == 0 && !ground.getPitPosition().get(ground.getPitPositionSize() - 2)){
				ground.setPitPosition(ground.getPitPositionSize() - 1, true);
				pitInterval = (int)(Math.random()*15) + 3;
			}
			for(int x=0; x<ground.getPitPositionSize(); x++){
				if(ground.getPitPosition().get(x)==true){
					if(x-1>=0){
						ground.setPitPosition(x-1, true);
						ground.setPitPosition(x, false);
					}
					else if(x-1<0){
						ground.setPitPosition(x, false);
					}
				}
			}
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public class thread implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                Thread.sleep(200);
                player.isJumping = false;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                new Thread(this).start();
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
    public static void main(String[] args)
    {
       Game app = new Game();
    }
}