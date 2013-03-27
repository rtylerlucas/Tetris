import java.awt.*;
import javax.swing.*;
/**
*@author Russell Tyler Lucas
*@version 69
*This class runs the main method 
*and puts the whole frame together
*Its TETRIS!!!
*/
public class Tetris
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PlayingPanel panel = new PlayingPanel();
		panel.setPreferredSize(new Dimension(450, 700));
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}