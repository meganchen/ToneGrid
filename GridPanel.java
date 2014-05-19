/*GridPanel.java.
* This class creates the matrix of buttons in the ToneGrid
	
	Date Created: May 16, 2014
	Creator: Megan Chen
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
	
	public GridPanel(ToneGrid t, TGPlayer player){
		setPreferredSize(new Dimension(370,370));
		setBackground(Color.BLACK);
		
		tg = t;
		tgp = player;
		gridButtons = new LinkedList<JButton>();
		yellow = new ImageIcon("img/yellow.png");
		gray = new ImageIcon("img/gray.png");
		blue = new ImageIcon("img/blue.png");
		
		//creates a 16x16 panel of boxes
		GridLayout tgLayout = new GridLayout(ToneGrid.GRID_DIMENSION,ToneGrid.GRID_DIMENSION,0,0);
		//adds ToneGrid buttons to pane
		for(int i = 0; i < Math.pow(ToneGrid.GRID_DIMENSION,2); i++){
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
			
			//calculates the column the box is in
			int bCol = bIndex % ToneGrid.GRID_DIMENSION;

			//calculates which row the box is in
			int bRow = 0;
			while (!(bIndex < (bRow * ToneGrid.GRID_DIMENSION)))
				bRow++;
			bRow--; //accounts for off by 1 error
			
			System.out.println("Col: " + bCol);
			System.out.println("Row: " + bRow);
			
			tg.toggle(bCol, bRow);
			
			//changes color according to boolean value in tg ToneGrid
			if(tg.getBool(bCol,bRow)) 
				gridButtons.get(bIndex).setIcon(yellow);
			else 
				gridButtons.get(bIndex).setIcon(gray);
		}
	}
	
	/*Changes all the yellow boxes in the column to blue if the column is currently playing*/
	public static void setBlue(int column, LinkedList<Integer> notes) {
		for (int i = 0; i < notes.size(); i++) {
			int row = notes.get(i);
			gridButtons.get((row * ToneGrid.GRID_DIMENSION) + column).setIcon(blue);
		}
	}

	public static void setYellow(int column, LinkedList<Integer> notes) {
		for (int i = 0; i < notes.size(); i++) {
			int row = notes.get(i);
			gridButtons.get((row * ToneGrid.GRID_DIMENSION) + column).setIcon(yellow);
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