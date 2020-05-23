import java.awt.Color;
public class Ground extends World
{
	int height;
	boolean pit;
	Color col;
    public Ground(int hieght, boolean pit, Color col)
    {

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
}