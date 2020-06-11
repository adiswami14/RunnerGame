import java.awt.Color;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
public class Ground extends World
{
	//add key listener later
	private int height;
	private boolean pit;
	private Color col;
	private int groundColumns = 10;
	private int countRight = 0;
	private int pitInterval = 5;
	private Character player;
	private ArrayList<Boolean> pitPosition;
	public Ground(double x, double y)
	{
		super(x,y);
	}
    public Ground(double x, double y, int height, boolean pit, Color col, Character player)
    {
		super(x, y);
		this.height = height;
		this.pit = pit;
		this.col = col;
		this.player = player;
		pitPosition = new ArrayList<Boolean>();
		for(int z=0; z<groundColumns; z++)
			pitPosition.add(false);
	}
	public void setPlayer(Character player)
	{
		this.player = player;
	}
	public void keepDrawing()
	{
			countRight++;
			if(countRight%pitInterval == 0 && !getPitPosition().get(getPitPositionSize() - 2)){
				setPitPosition(getPitPositionSize() - 1, true);
				pitInterval = (int)(Math.random()*15) + 3;
			}
			for(int x=0; x<getPitPositionSize(); x++){
				if(getPitPosition().get(x)==true){
					if(x-1>=0){
						setPitPosition(x-1, true);
						setPitPosition(x, false);
					}
					else if(x-1<0){
						setPitPosition(x, false);
					}
				}
			}
	}
	public void draw(Graphics g)
	{
		g.setColor(getColor());
		int count = 0;
		for(int x=0; x<1000; x++){
			if(x%100 == 0){ //evenly divides width into 10 rectangles
				if(getPitPosition().get(count) == false){
					g.fillRect(x, 600-getHeight(), 1000/10, getHeight()); //so this goes from bottom to top instead of top to bottom

					/*
					if(count%2==0){							//alternates color to see each rectangle
						ground.setColor(Color.YELLOW);
						g.setColor(ground.getColor());
					}
					else{
						ground.setColor(Color.GREEN);
						g.setColor(ground.getColor());
					}*/
					/*if(player.getX() == x && getPitPosition().get(count))
						gameOver = true;*/
				}
				else 
				{
					//gameOver = true;
					//if(getPitPosition().get(count) == true)
						//System.out.println("game over");
					//player.setY(player.getY()+50);
				}
				count++;
			}
		}
	}
    public int getHeight()
    {
		return height;
	}
	public boolean getPit(){
		return pit;
	}
	public Color getColor(){
		return col;
	}
	public ArrayList<Boolean> getPitPosition(){
		return pitPosition;
	}
	public int getPitPositionSize(){
		return pitPosition.size();
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setColor(Color col){
		this.col = col;
	}
	public void setPitPosition(int a, boolean bool){
		pitPosition.set(a, bool);
	}

}