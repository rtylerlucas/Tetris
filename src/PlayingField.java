import java.awt.*;
import java.awt.event.*;
/**
*@author Russell Tyler Lucas
*@version 69
*This class represents the PlayingField that all the settled 
*Pieces are stored
*/
public class PlayingField
{
	protected final int WIDTH = 10;
	protected final int HEIGHT = 25;
	protected int score=0;
	protected int level=1;
	protected int fallTime =400;
	protected Color[][] tileList = new Color[HEIGHT][WIDTH];
	

/**
*This method identifys if a row is full,
*and then handles clearing and pulling the rows
*that need it
*/
	public void checkForClears()
	{
		int colNum=0;
		for(int r=1;r<tileList.length;r++)
		{
			colNum=0;
			for(int c=0;c<tileList[r].length;c++)
			{
				if(tileList[r][c]!=null)
				{
					colNum++;
				}
				
			}
			if(colNum==(tileList[r].length))
			{
				
				
					for(int clr=0;clr<tileList[r].length;clr++)
					{
						tileList[r][clr]=null;
				
					}
					
					for(int finalRow=(r);finalRow>0;finalRow--)
					{
						for(int column=0;column<tileList[finalRow].length;column++)
						{
							tileList[finalRow][column]=tileList[finalRow-1][column];
						}
					}
					score = score+100;
			}
		}
	}
				
		
/**
*This method checks to see if the Player loses
*@return boolean of if the player lost
*/
	public boolean isLossConditionMet()
	{
		
		boolean condition = false;
		int col = 0;
		while(!condition && col<tileList[0].length)
		{
			condition = tileList[0][col]!=null;
			col++;
		}
		return condition;
	}
	
/**
*@param int x int y of checking this position if it is vacant
*@return boolean of if the tile is vacant or not
*/
	public boolean isTileVacant(int x, int y)
	{
		if(x==-1)
		{
			return true;
		}
		if(tileList[x][y]==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
/**
*@param int x int y Color color 
*fills the tile in intaken position with intaken color
*/
	public void fillTile(int x, int y, Color color)
	{
		tileList[x][y]= color;
	
	}
   /**
	 *@param Graphics g, Dimension tileDimension
	 *allows the PlayingBoard to draw itself
	 */
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
	
   /**
	 *resets the board to a new game
	 */
	public void resetBoard()
	{
		tileList = new Color[HEIGHT][WIDTH];
		score = 0;
		level = 1;
		fallTime=400;
	}
	
	/**
	 *controls the level which affects fall speed
	 *level is based on amount of cleared rows
	 */
	public void checkLevel()
	{
		if(score>=1000&&score<2000)
		{
			level=2;
		}
		if(score>=2000&&score<3000)
		{
			level=3;
		}
		if(score>=3000&&score<4000)
		{
			level=4;
		}
		if(score>=4000&&score<5000)
		{
			level=5;
		}
		if(score>=5000&&score<6000)
		{
			level=6;
		}
		if(score>=6000)
		{
			level=7;
		}
	
	}
	
	/**
	 *@return int of fall time
	 *controls fall time based on level
	 */
	public int getFallTime()
	{
		
		if(level==1)
		{
			fallTime= 500;
		}
		if(level==2)
		{
			fallTime= 375;
		}
		if(level==3)
		{
			fallTime= 275;
		}
		if(level==4)
		{
			fallTime= 200;
		}
		if(level==5)
		{
			fallTime= 150;
		}
		if(level==6)
		{
			fallTime= 100;
		}
		if(level==7)
		{
			fallTime= 50;
		}
		return fallTime;
	
	}
	/**
	 *@return int of amount of rows
	 */
	public int getRows()
	{
		return HEIGHT;
	
	}
	/**
	 *@return int of amount of columns
	 */
	public int getCols()
	{
		return WIDTH;
	
	}
	/**
	 *@return int of score
	 */
	public int getScore()
	{
		return score;
	}
	/**
	 *@return int of level
	 */
	public int getLevel()
	{
		return level;
	}
	/**
	 *@param int newScore
	 * sets score to param
	 */
	public void setScore(int newScore)
	{
		score = newScore;
	}
	/**
	 *@param int newLevel
	 * sets level to param
	 */
	public void setLevel(int newLevel)
	{
		level = newLevel;
	}
	/**
	 *@return Color[][] list of colors in board
	 */
	public Color[][] getBoard()
	{
		return tileList;
	}
}
		
	