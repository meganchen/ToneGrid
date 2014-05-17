/*ToneGridPanel.java
	
	Date Created: May 16, 2014
	Creator: Megan Chen
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToneGridPanel extends JPanel{

	//Constructor
	public ToneGridPanel(){
		ToneGrid tg = new ToneGrid();
		setPreferredSize(new Dimension(500,500));
		
		GridLayout tgLayout = new GridLayout(ToneGrid.GRID_DIMENSION,ToneGrid.GRID_DIMENSION,0,0);
		
		//adds ToneMatrix buttons to pane
		for(int i = 0; i < Math.pow(ToneGrid.GRID_DIMENSION,2); i++){
			String s = "" + i;
			ImageIcon img = new ImageIcon("img/gray.png", s);
			JButton b = new JButton();
			b.setFocusable(true);
			b.setIcon(img);
			b.setContentAreaFilled(false);
			//b.setBorder(BorderFactory.createEmptyBorder());
			b.setFocusPainted(false);
			b.setPreferredSize(new Dimension(10, 20));
			add(b);
		}
		setLayout(tgLayout);
		
	}
}