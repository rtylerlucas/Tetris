import java.awt.Color;
/**
*@author Russell Tyler Lucas
*@version 69
*This class creates the yellow Square Piece
*/
public class SquarePiece extends Piece
{

	public static int[][][] model = 
	{
		{{0,1,1,0},
		 {0,1,1,0}, 
		 {0,0,0,0},
		 {0,0,0,0}},
		 
		 {{0,1,1,0},	
		  {0,1,1,0},
		  {0,0,0,0},
		  {0,0,0,0}},
		 
		 {{0,1,1,0},
		  {0,1,1,0}, 
	     {0,0,0,0},
		  {0,0,0,0}},
		  
		  {{0,1,1,0},	
		   {0,1,1,0},
		   {0,0,0,0},
		   {0,0,0,0}}
	};
	/**
	 *This is the constructor for the Square Piece 
	 */
	public SquarePiece(int x, int y, PlayingField board)
	{
		super(x,y, Color.yellow, board, SquarePiece.model);
	
	}
}