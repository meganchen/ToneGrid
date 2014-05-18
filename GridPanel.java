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
	private LinkedList<JButton> gridButtons;
	ImageIcon yellow, gray;
	
	public GridPanel(ToneGrid t){
		tg = t;
		gridButtons = new LinkedList<JButton>();
		setPreferredSize(new Dimension(370,370));
		setBackground(Color.BLACK);
		yellow = new ImageIcon("img/yellow.png");
		gray = new ImageIcon("img/gray.png");
		
		GridLayout tgLayout = new GridLayout(ToneGrid.GRID_DIMENSION,ToneGrid.GRID_DIMENSION,0,0);
		
		//adds ToneGrid buttons to pane
		//gridButtons = newGrid(gridButtons); //using method
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

	/*public LinkedList<JButton> newGrid(LinkedList<JButton> grid) {
		grid = new LinkedList<JButton>();

		for(int i = 0; i < Math.pow(ToneGrid.GRID_DIMENSION,2); i++){
			JButton b = new JButton();
			b.setFocusable(true);
			b.setIcon(gray);
			b.setContentAreaFilled(false);
			b.setBorder(BorderFactory.createEmptyBorder());
			b.setFocusPainted(false);
			b.setPreferredSize(new Dimension(10, 20));
			b.addActionListener(new BoxListener());
			grid.add(b);
			add(b);
		}
		return grid;
	}*/
	
	//changes button colors when box is clicked
	private class BoxListener implements ActionListener{
		
		public void actionPerformed (ActionEvent event){
			int bIndex = gridButtons.indexOf(event.getSource());
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
}