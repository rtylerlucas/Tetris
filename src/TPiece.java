import java.awt.Color;
/**
*@author Russell Tyler Lucas
*@version 69
*This class creates the purple T Piece
*/
public class TPiece extends Piece
{

	public static int[][][] model = 
	{
		{{0,0,1,0},
		 {0,1,1,1}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		 
		 {{0,0,0,0},	
		  {0,0,1,0},
		  {0,0,1,1},
		  {0,0,1,0}},
		 
		 {{0,0,0,0},
		  {0,1,1,1}, 
	     {0,0,1,0},
		  {0,0,0,0}},
		  
		  {{0,0,0,0},	
		   {0,0,1,0},
		   {0,1,1,0},
		   {0,0,1,0}}
	};
	
	/**
	 *This is the constructor for the T Piece 
	 */
	
	public TPiece(int row,int col, PlayingField board)
	{
		super(row,col, Color.magenta, board, TPiece.model);
		
	}
}