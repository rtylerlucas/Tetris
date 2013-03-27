import java.awt.Color;
/**
*@author Russell Tyler Lucas
*@version 69
*This class creates the blue J Piece
*/
public class JPiece extends Piece
{

	public static int[][][] model = 
	{
		{{1,0,0,0},
		 {1,1,1,1}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		 
		 {{0,0,1,1},	
		  {0,0,1,0},
		  {0,0,1,0},
		  {0,0,1,0}},
		 
		 {{0,0,0,0},
		  {1,1,1,1}, 
	     {0,0,0,1},
		  {0,0,0,0}},
		  
		  {{0,0,1,0},	
		   {0,0,1,0},
		   {0,0,1,0},
		   {0,1,1,0}}
	};
	

	/**
	 *This is the constructor for the J Piece 
	 */
	public JPiece(int row,int col, PlayingField board)
	{
		super(row,col, Color.blue, board, JPiece.model);
		
	}
}