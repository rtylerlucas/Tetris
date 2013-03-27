import java.awt.Color;
/**
*@author Russell Tyler Lucas
*@version 69
*This class creates the orange L Piece
*/
public class LPiece extends Piece
{

	public static int[][][] model = 
	{
		{{0,0,0,1},
		 {1,1,1,1}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		 
		 {{0,0,1,0},	
		  {0,0,1,0},
		  {0,0,1,0},
		  {0,0,1,1}},
		 
		 {{0,0,0,0},
		  {1,1,1,1}, 
	     {1,0,0,0},
		  {0,0,0,0}},
		  
		  {{0,1,1,0},	
		   {0,0,1,0},
		   {0,0,1,0},
		   {0,0,1,0}}
	};
	
	/**
	 *This is the constructor for the L Piece 
	 */
	
	public LPiece(int row,int col, PlayingField board)
	{
		super(row,col, Color.orange, board, LPiece.model);
		
	}
}