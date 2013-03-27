import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
/**
*@author Russell Tyler Lucas
*@version 69
*This class represents the PlayingPanel
*that puts together the GUI of the entire game
*/
public class PlayingPanel extends JPanel implements KeyListener, ActionListener
{
	private Timer fallTimer;
	private Piece activePiece;
	private Dimension dimension;
	private PlayingField field;
	private JLabel theScore, theLevel;
	private Piece previewPiece;
	private JButton saveButton, load1,load2,load3;
/**
 *This is the constructor of the PlayingPanel
 */
	public PlayingPanel()
	{
		setLayout (new BorderLayout());
		
		field = new PlayingField();
		fallTimer = new Timer(field.getFallTime(), this);
		dimension = new Dimension(20,20);
		
		theScore = new JLabel("Score: "+field.getScore());
		theScore.setForeground(Color.white);
		
		theLevel = new JLabel("Level: "+field.getLevel());
		theLevel.setForeground(Color.white);
		
		fallTimer.start();
		activePiece = newPiece();
		previewPiece = newPiece();
		previewPiece.setX(previewPiece.getX()+3);
		
		setFocusable(true);
		addKeyListener(this);
		setBackground(Color.black);
		
		
		EastPanel east = new EastPanel();
		
		east.add(theScore);
		east.add(theLevel);
		
		east.setBackground(Color.black);
		add(east, BorderLayout.EAST);
		
		Panel south = new Panel();
		south.setBackground(Color.black);
		saveButton = new JButton("Save");
		saveButton.addActionListener(new SaveListener());
		load1 = new JButton("Load File 1");
		load2 = new JButton("Load File 2");
		load3 = new JButton("Load File 3");
		south.add(saveButton);
		south.add(load1);
		south.add(load2);
		south.add(load3);
		
		add(south, BorderLayout.SOUTH);
		
		
		
		
	
		
	
	}
	/**
	 *@param Graphics g
	 *This method draws the entire main panel 
	 *and allows it to be resizable
	 */
	public void paintComponent(Graphics g)
	{
		
		int width = getWidth() / field.getCols();
		int height = getHeight() / (field.getRows()+4);
		int dim;
		if(width < height)
		{ 
			dim = width; 
		}
		
		else
		{ 
			dim = height; 
		}
		
		super.paintComponent(g);
		Dimension tile = new Dimension(dim, dim);
		field.draw(g, tile);
		activePiece.draw(g, tile);
	
	}
	/**
	 *This class represents the EastPanel
	 *That holds the score and upcoming Piece
	 */
	public class EastPanel extends JPanel
	{
		/**
	    *@param Graphics g
	    *This method draws the east panel 
	    */
		public void paintComponent(Graphics g)
		{
			int w = getWidth() / field.getCols();
			int h = getHeight() / (field.getRows());
			int dimen;
			
			if(w < h)
			{ 
				dimen = w; 
			}
			
			else
			{ 
				dimen = h; 
			}
			
			super.paintComponent(g);
			Dimension eastTile = new Dimension(dimen, dimen);
			
			
			previewPiece.draw(g, eastTile);
			
		
		}
	}
	
	
	
		/**
		 @param ActionEvent e
	    * This method tells the function what to do
		 *when the timer fires
	    */
		public void actionPerformed(ActionEvent e) 
		{
		
			if(field.isLossConditionMet())
			{
				int message = JOptionPane.showConfirmDialog(null,
										"Would you like to play again?",
																		"You Lost!",
				    										JOptionPane.YES_NO_OPTION);
			
				if(message == 0)
				{
					field.resetBoard();
				}
				else
				{
						System.exit(0);
				}
			}
				
			if(!activePiece.move(activePiece.getX() + 1,activePiece.getY()))
			{
				activePiece.settle();
				field.checkForClears();
				field.checkLevel();	
				activePiece = previewPiece;
				activePiece.setX(activePiece.getX()-3);
				previewPiece = newPiece();
				previewPiece.setX(previewPiece.getX()+3);
			}
				
				field.checkForClears();
				field.checkLevel();
				theScore.setText("            Score: "+field.getScore());
				theLevel.setText("Level: "+field.getLevel());
				
				
				
				repaint();
				
		}
	
	/**
	 *@return Piece new random Piece
	 */
	public Piece newPiece()
	{
		Random rand = new Random();
		int value = rand.nextInt(7);
		Piece piece = null;
		fallTimer.setDelay(field.getFallTime());
		if(value==0)
		{
			piece = new LinePiece(-1, 3, field);
		}
		if(value==1)
		{
			piece = new SquarePiece(-1,3, field);
		}
		if(value==2)
		{
			piece = new LPiece(-1, 3, field);
		}
		if(value==3)
		{
			piece = new JPiece(-1,3, field);
		}
		if(value==4)
		{
			piece = new ZPiece(-1,3, field);
		}
		if(value==5)
		{
			piece = new SPiece(-1,3, field);
		}
		if(value==6)
		{
			piece = new TPiece(-1,3, field);
		}
		
		return piece;	
	}
		/**
		 *@param KeyEvent e
	    *This method tells what to do
		 *when keys are pressed
		 *controls movement
	    */
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					activePiece.move(activePiece.getX(),activePiece.getY() - 1);
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					activePiece.move(activePiece.getX(),activePiece.getY() + 1);
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					fallTimer.setDelay(50);
				}
				else if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					activePiece.rotate();
				}
				repaint();
			}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
					{
						fallTimer.setDelay(field.getFallTime());
					}
			
			}
	  /**
	   *This Class handles Saving based on a button pressed
		*info is saved in a .txt file
	   */
		public class SaveListener implements ActionListener 
		{
			//fallTimer.stop();
			String file1 = "fileSave1.txt";
			
			String file2 = "fileSave2.txt";
			String file3 = "fileSave3.txt";
			
			FileWriter fw;
			BufferedWriter bw;
			PrintWriter outFile;
			/**
			 *@param ActionEvent event
	       *Specificlally handles what happens after save button pressed
	       */
			public void actionPerformed(ActionEvent event) 
			{
				Object[] options = {"File 3",
                    "File 2",
                    "File 1"};
						  
					int n = JOptionPane.showOptionDialog(null,
					    "Which File would you like to overide?",
					    "Save File",
					    JOptionPane.YES_NO_CANCEL_OPTION,
					    JOptionPane.QUESTION_MESSAGE,
					    null,
					    options,
					    options[2]);
						try
						{
						if(n==0)
						{
						fw = new FileWriter(file3);
						}
						
						if(n==1)
						{
						fw = new FileWriter(file2);
						}
						if(n==2)
						{
						fw = new FileWriter(file1);
						}
						bw = new BufferedWriter(fw);
						outFile = new PrintWriter(bw);
						
						
						outFile.println(""+field.getScore());
						outFile.println(""+field.getLevel());
						
						for(int r=1;r<field.getBoard().length;r++)
						{
							
							for(int c=0;c<field.getBoard()[r].length;c++)
							{
								outFile.print(field.getBoard()[r][c]+";");
							
							}
								outFile.print("\n");
						}
						
						
						outFile.close();
						System.exit(0);

						}
						catch(IOException e)
						{
						System.out.println("That didn't work..");
						}
				
			}	
		}
		
		// public class Load1Listener implements ActionListener 
// 		{
// 
// 			public void actionPerformed(ActionEvent event) 
// 			{
// 				File file = new File("fileSave1.txt");
// 				Scanner scan = new Scanner(file);
// 				
// 				String scoreStr = scan.nextLine();
// 				fileScore = Integer.parseInt(scoreStr);
// 				
// 				String levelStr = scan.nextLine();
// 				fileLevel = Integer.parseInt(levelStr);
// 				
// 				
// 				while(scan.hasNext())
// 				{
// 				
// 					
// 					for(int r=0;r<field.getBoard().length;r++)
// 					{
// 						String workingRow = scan.nextLine();
// 						temp = workingRow.split(";");
// 						
// 						for(int c=0;c<field.getBoard()[r].length;c++)
// 						{
// 							int newCol = temp[c]
// 							field.getBoard()[r][c]=field.getBoard()[r][c]
// 						
// 						}
// 					}
// 					
// 					
// 			}	
// 		}


		/**
	    *The Load Classes were the only part of the homework
		 *I could not get to function properly.
		 *The saving works to the txt file but I couldn't
		 *get around accessing the colors after they were
		 *saved as Strings in the txt file
	    */  
		public class Load2Listener implements ActionListener 
		{

			public void actionPerformed(ActionEvent event) 
			{
								
			}	
		}
		/**
	    *The Load Classes were the only part of the homework
		 *I could not get to function properly.
		 *The saving works to the txt file but I couldn't
		 *get around accessing the colors after they were
		 *saved as Strings in the txt file
	    */  
		public class Load3Listener implements ActionListener 
		{

			public void actionPerformed(ActionEvent event) 
			{
								
			}	
		}


	
		
	
		
}