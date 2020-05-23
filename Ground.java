import java.awt.Color;
import java.util.*;
import java.awt.event.*;
public class Ground extends World implements KeyListener
{
	//add key listener later
	private int height;
	private boolean pit;
	private Color col;
	private int groundColumns;
	private ArrayList<Boolean> pitPosition;
    public Ground(int height, boolean pit, Color col)
    {
		this.height = height;
		this.pit = pit;
		this.col = col;
		pitPosition = new ArrayList<Boolean>();
		for(int x=0; x<groundColumns; x++)
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 32) //spacebar
		{
		}
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}


}