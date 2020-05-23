import java.awt.Color;
public class Ground extends World
{
	//add key listener later
	int height;
	boolean pit;
	Color col;
	//ArrayList<boolean> pitPosition;
    public Ground(int height, boolean pit, Color col)
    {
		this.height = height;
		this.pit = pit;
		this.col = col;
		//pitPosition = new ArrayList<boolean>();
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