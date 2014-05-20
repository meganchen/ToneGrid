/*GridPanel.java.
* This class creates the 16x16 matrix of buttons in the ToneGrid and creates the BoxListeners that control them
	
	Date Created: May 16, 2014
	Creator: Megan Chen, Galen Chuang (setColor method)
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GridPanel extends JPanel{
	private ToneGrid tg;
	private TGPlayer tgp;
	private static LinkedList<JButton> gridButtons;
	private ImageIcon gray;
	private static ImageIcon yellow, blue;
	
	/*GridPanel constructor.
	*@param t ToneGrid that stores the selections to the grid
	*@param player the TGPlayer that plays the ToneGrid
	*/
	public GridPanel(ToneGrid t, TGPlayer player){
		setPreferredSize(new Dimension(370,370));
		setBackground(Color.BLACK);
		
		tg = t;
		tgp = player;
		gridButtons = new LinkedList<JButton>();
		//imports the different color box images 
		yellow = new ImageIcon("img/yellow.png");
		gray = new ImageIcon("img/gray.png");
		blue = new ImageIcon("img/blue.png");
		
		//creates a 16x16 panel of boxes
		GridLayout tgLayout = new GridLayout(tg.GRID_DIMENSION,tg.GRID_DIMENSION,0,0);
		//adds ToneGrid buttons to pane
		for(int i = 0; i < Math.pow(tg.GRID_DIMENSION,2); i++){
			JButton b = new JButton();
			b.setFocusable(true);
			b.setIcon(gray);
			b.setContentAreaFilled(false);
			b.setBorder(BorderFactory.createEmptyBorder());
			b.setFocusPainted(false);
			b.setPreferredSize(new Dimension(10, 20));
			b.addActionListener(new BoxListener());
			gridButtons.add(b);
			add(b);
		}
		setLayout(tgLayout);
	}
	
	//changes button colors when box is clicked
	private class BoxListener implements ActionListener{
		
		public void actionPerformed (ActionEvent event){
			int bIndex = gridButtons.indexOf(event.getSource());
			
			//calculates the column of the box
			int bCol = bIndex % tg.GRID_DIMENSION;

			//calculates which row of the box
			int bRow = 0;
			while (!(bIndex < (bRow * tg.GRID_DIMENSION)))
				bRow++;
			bRow--; //accounts for off by 1 error
			
			//For testing. Tracks user inputs in the console
			System.out.println("Col: " + bCol);
			System.out.println("Row: " + bRow);
			
			//switches the T/F value of tha location in the ToneGrid
			tg.toggle(bCol, bRow);
			
			//changes color according to boolean value in tg ToneGrid
			if(tg.getBool(bCol,bRow)) 
				gridButtons.get(bIndex).setIcon(yellow);
			else 
				gridButtons.get(bIndex).setIcon(gray);
		}
	}
	
	/*Changes all the yellow boxes in the column to blue if the column is currently playing
	*@param column the column of the box
	*@param notes LinkedList of notes currently selected
	*@param color the color to set the box of question
	*/
	public static void setColor(int column, LinkedList<Integer> notes, String color) {
		for (int i = 0; i < notes.size(); i++) {
			int row = notes.get(i);
			if (color.equals("blue")) gridButtons.get((row * ToneGrid.GRID_DIMENSION) + column).setIcon(blue);
			if (color.equals("yellow")) gridButtons.get((row * ToneGrid.GRID_DIMENSION) + column).setIcon(yellow);
		}
	}

	/*setBoxes method. Sets the boxes by color according to the current state of the tone grid
	*/
	public void setBoxes(){
		for(int i = 0; i < tg.GRID_DIMENSION; i++){
			for(int j = 0; j < tg.GRID_DIMENSION; j++){
				if(tg.getBool(j,i))
					gridButtons.get((i*tg.GRID_DIMENSION)+j).setIcon(yellow);
				else
					gridButtons.get((i*tg.GRID_DIMENSION)+j).setIcon(gray);
			}
		}
	}
}