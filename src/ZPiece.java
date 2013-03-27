import java.awt.Color;
/**
*@author Russell Tyler Lucas
*@version 69
*This class creates the red Z Piece
*/
public class ZPiece extends Piece
{

	public static int[][][] model = 
	{
		{{1,1,0,0},
		 {0,1,1,0}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		 
		 {{0,0,1,0},	
		  {0,1,1,0},
		  {0,1,0,0},
		  {0,0,0,0}},
		 
		 {{1,1,0,0},
		 {0,1,1,0}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		  
		  {{0,0,1,0},	
		   {0,1,1,0},
		   {0,1,0,0},
		   {0,0,0,0}},
	};
	
	/**
	 *This is the constructor for the Z Piece 
	 */
	
	public ZPiece(int row,int col, PlayingField board)
	{
		super(row,col, Color.red, board, ZPiece.model);
		
	}
}