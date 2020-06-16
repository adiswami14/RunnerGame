import java.awt.Color;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class Ground extends World
{
	//add key listener later
	private int height;
	private Color col;
	private int groundColumns = 10;
	private int countRight = 0;
	private int pitInterval = 5;
	private Character player;
	public boolean gameOver = false;
	private boolean pitsEnabled= true;
	private ArrayList<Block> blocks;
	public Ground(double x, double y)
	{
		super(x,y);
	}
    public Ground(double x, double y, int height, Color col, Character player)
    {
		super(x, y);
		this.height = height;
		this.col = col;
		this.player = player;
		blocks = new ArrayList<>();
		for(int z=0; z<groundColumns; z++)
		{
			blocks.add(new Block(z*100, 600-height,false, false));		//ground is split into 10 columns, so z*100 gives the x coordinate bc frame is 1000 pixels wide
		}
	}
	public void setPlayer(Character player)
	{
		this.player = player;
	}
	public Character getPlayer()
	{
		return player;
	}
	public void keepDrawing()
	{
			countRight++;
			if(countRight % pitInterval == 0 && !blocks.get(blocks.size()-2).isPit())	//can't have 2 pits together so if the 2nd to last block is not a pit									
			{																			//then set the last block to a pit
				blocks.get(blocks.size()-1).setPit(true);
				pitInterval = (int)(Math.random()*15) + 3;
			}
			for(int x=0; x<blocks.size(); x++){
				if(blocks.get(x).isPit()){
					if(x-1>=0){
						blocks.get(x-1).setPit(true);
						blocks.get(x).setPit(false);
					}
					else if(x-1<0){
						blocks.get(x).setPit(false);
					}
				}
			}
			
			if(!blocks.get(blocks.size()-1).isPit() && countRight%Obstacle.obstacleInterval ==0 && 
			!blocks.get(blocks.size()-2).hasObstacle() ){
				
				blocks.get(blocks.size()-1).setObstacle(true);
				Obstacle.obstacleInterval = (int)(Math.random()*15) + 3;
			}

			for(int x=0; x<blocks.size(); x++){
				if(blocks.get(x).hasObstacle()){
					if(x-1>=0){
						blocks.get(x-1).setObstacle(true);
						blocks.get(x).setObstacle(false);
					}
					else if(x-1<0){
						blocks.get(x).setObstacle(false);
					}
				}
			}

	}
	public void draw(Graphics g)
	{
		g.setColor(getColor());
		for(int x=0;x<1000;x++)
		{
			if(x%100 ==0)
			{
				if(!blocks.get(x/100).isPit())
				{
					blocks.get(x/100).draw(g, this);
				}
				else if(blocks.get(x/100).isPit())
				{
					if(player.isInRangeOfPit(player.getX(), x+50, 50) && player.getY()>=600-getHeight() && pitsEnabled)
					{
						gameOver = true;
					}
				}
			}
		}
		if(player.getHealth()<=0)
			gameOver = true;
	}
    public int getHeight()
    {
		return height;
	}
	public Color getColor(){
		return col;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setColor(Color col){
		this.col = col;
	}

}