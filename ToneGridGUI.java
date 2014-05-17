/* ToneGridGUI.java
*
	Date Created: May 16, 2014
	Creator: Megan Chen
*/

import javax.swing.JFrame;

//remove
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ToneGridGUI extends JPanel{ //remove "extends JPanel"
	private ToneGrid tg;
	private LinkedList<JButton> gridButtons;
	ImageIcon yellow, gray;
	
	public ToneGridGUI(){
		tg = new ToneGrid();
		gridButtons = new LinkedList<JButton>();
		setPreferredSize(new Dimension(370,370));
		setBackground(Color.BLACK);
		yellow = new ImageIcon("img/yellow.png");
		gray = new ImageIcon("img/gray.png");
		
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
	
	public static void main(String[]args){
		JFrame frame = new JFrame("Tone Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		ToneGridGUI tgp = new ToneGridGUI(); //ToneGridPanel
		frame.add(tgp);

		frame.pack();
		frame.setVisible(true);
	}

}