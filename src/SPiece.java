import java.awt.Color;
/**
*@author Russell Tyler Lucas
*@version 69
*This class creates the green S Piece
*/
public class SPiece extends Piece
{

	public static int[][][] model = 
	{
		{{0,0,1,1},
		 {0,1,1,0}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		 
		 {{0,0,1,0},	
		  {0,0,1,1},
		  {0,0,0,1},
		  {0,0,0,0}},
		 
		 {{0,0,1,1},
		  {0,1,1,0}, 
		  {0,0,0,0},
		  {0,0,0,0}},
		  
		  {{0,0,1,0},	
		   {0,0,1,1},
		   {0,0,0,1},
		   {0,0,0,0}},
	};
	
	/**
	 *This is the constructor for the S Piece 
	 */
	
	public SPiece(int row,int col, PlayingField board)
	{
		super(row,col, Color.green, board, SPiece.model);
		
	}
}