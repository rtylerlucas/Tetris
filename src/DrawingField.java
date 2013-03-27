import java.awt.*;
import java.awt.event.*;

public class DrawingField
{
	protected final int WIDTH = 4;
	protected final int HEIGHT = 4;
	protected int score=0;
	protected int level=1;
	protected int fallTime =400;
	protected Color[][] tileList = new Color[HEIGHT][WIDTH];
	
	
	
	public void fillTile(int x, int y, Color color)
	{
		tileList[x][y]= color;
	
	}
	
	public void draw(Graphics g, Dimension tileDimension)
	{
		for(int row=0;row<tileList.length;row++)
		{
			for(int col=0; col<tileList[row].length; col++)
			{
				g.setColor(Color.white);
				g.drawRect(col*tileDimension.width, 
								row*tileDimension.height, tileDimension.width,
																 tileDimension.height);
											 
				if(tileList[row][col] != null)
				{
					g.setColor(tileList[row][col]);
					g.fillRect(col*tileDimension.width, 
								row*tileDimension.height, tileDimension.width,
																 tileDimension.height);
					g.setColor(Color.black);
					g.drawRect(col*tileDimension.width, 
								row*tileDimension.height, tileDimension.width,
																 tileDimension.height);
				}
											 
			}
		}
	}
	
			
	public int getRows()
	{
		return HEIGHT;
	
	}
	
	public int getCols()
	{
		return WIDTH;
	
	}
	
}
		
	