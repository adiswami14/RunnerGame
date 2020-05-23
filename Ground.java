import java.awt.Color;
import java.util.*;
import java.awt.event.*;
public class Ground extends World
{
	//add key listener later
	private int height;
	private boolean pit;
	private Color col;
	private int groundColumns;
	private ArrayList<Boolean> pitPosition;
    public Ground(int x, int y, int height, boolean pit, Color col)
    {
		super(x, y);
		this.height = height;
		this.pit = pit;
		this.col = col;
		pitPosition = new ArrayList<Boolean>();
		for(int z=0; z<groundColumns; z++)
			pitPosition.add(false);
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
	public void setHeight(int height){
		this.height = height;
	}
	public void setColor(Color col){
		this.col = col;
	}
	public void setPit(int a){
		pitPosition.set(a, true);
	}	
}