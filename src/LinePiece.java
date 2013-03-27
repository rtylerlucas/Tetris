import java.awt.Color;
/**
*@author Russell Tyler Lucas
*@version 69
*This class creates the light blue Line Piece
*/
public class LinePiece extends Piece
{
	
	public static int[][][] model = 
	{
		{{0,0,0,0},
		 {1,1,1,1}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		 
		 {{0,0,1,0},	
		  {0,0,1,0},
		  {0,0,1,0},
		  {0,0,1,0}},
		 
		 {{0,0,0,0},
		  {1,1,1,1}, 
	     {0,0,0,0},
		  {0,0,0,0}},
		  
		  {{0,0,1,0},	
		   {0,0,1,0},
		   {0,0,1,0},
		   {0,0,1,0}}
	};
	

	/**
	 *This is the constructor for the Line Piece 
	 */
	public LinePiece(int row,int col, PlayingField board)
	{
		super(row,col, Color.cyan, board, LinePiece.model);
		
	}
}
	
