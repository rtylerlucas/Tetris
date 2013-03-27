import java.awt.*;
/**
*@author Russell Tyler Lucas
*@version 69
*This abstract class represents all types of Piece
*it sets how movement and drawing of pieces is handled
*/
abstract public class Piece 
{
	protected int row,col;
	protected Color color;
	protected int[][][] model;
	protected PlayingField board;
	protected int rotationIndex;
	/**
	 *This is the constructor to Piece
	 */
	public Piece(int row, int col, Color color, PlayingField board, int[][][] model)
	{
		this.row=row;
		this.col=col;
		this.color = color;
		this.board = board;
		this.model = model;
		rotationIndex=0;
		
	
	}
	/**
	 *@param int newX, int newY are the positions sought
	 *for the Piece to be moved to
	 *@return boolean of if move succeeds
	 */
	public boolean move(int newX, int newY)
	{
		int r = 0;
		int c = 0;
		boolean checker = true;
		
		
		while(checker &&r<model[rotationIndex].length)
		{
			c = 0;
			while(checker&& c<model[rotationIndex][r].length)
			{
				if(model[rotationIndex][r][c]==1)
				{
					checker = !(newX+r<0|| newY+c<0|| newX+r>= board.getRows()||
									newY+c>= board.getCols()||!board.isTileVacant(newX+r, newY+c));
				
				}
				c++;
			}
			r++;
		}
		if(checker==true)
		{
			row = newX;
			col = newY;
		}
		return checker;
	
	}
	/**
	 *rotates piece into 1 of 4 positions
	 *@return boolean of if rotation succeeds
	 */
	public boolean rotate()
	{
		boolean rotateCheck = true;
		int lastRotation = rotationIndex;
		
		rotationIndex++;
		
		if(rotationIndex>3)
		{
			rotationIndex=0;
		}
		
		if(!move(row,col))
		{
			rotationIndex=lastRotation;
			rotateCheck=false;
		}
		
		return rotateCheck;


	}
	/**
	 *Sets the active Piece into the firm block of Pieces
	 *on the bottom
	 */
	public void settle()
	{
		for(int r=0; r<model[rotationIndex].length; r++)
		{
			for(int c=0; c<model[rotationIndex][r].length; c++)
			{
				if(model[rotationIndex][r][c] == 1)
				{
					if(row+r >=0)
					{
						board.fillTile(r+row,c+col, color);
					}
				}
			}
		}

	}
	
	/**
	 *@param Graphics g, Dimension tileDimension
	 *allows the Piece to draw itself
	 */
	public void draw(Graphics g, Dimension tileDimension)
	{
		
		for(int r=0;r< model[rotationIndex].length; r++)
		{
			for(int c=0;c< model[rotationIndex][r].length; c++)
			{
				if(model[rotationIndex][r][c]==1)
				{
					g.setColor(color);
					g.fillRect((c+ col)*tileDimension.width, 
								(r+row)*tileDimension.height,tileDimension.width,
																	tileDimension.height);
					g.setColor(Color.black);
					g.drawRect((c+ col)*tileDimension.width, 
								(r+row)*tileDimension.height,tileDimension.width,
																	tileDimension.height);
				
				}
			}
		}
				
		
		
	}
	/**
	 *@return the row of the Piece
	 */
	public int getX()
	{
		return row;
	}
	/**
	 *@return the column of the Piece
	 */
	public int getY()
	{
		return col;
	}
	/**
	 *@oaram int newX sets a new position of the row 
	 */
	public void setX(int newX)
	{
		row = newX;
	}
	/**
	 *@oaram int newY sets a new position of the column
	 */
	public void setY(int newY)
	{
		col = newY;
	}
	
	
	
}


