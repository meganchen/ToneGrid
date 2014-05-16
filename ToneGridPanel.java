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
		
		GridLayout tgLayout = new GridLayout(ToneGrid.GRID_DIMENSION,ToneGrid.GRID_DIMENSION,4,4);
		
		//adds ToneMatrix buttons to pane
		for(int i = 0; i < Math.pow(ToneGrid.GRID_DIMENSION,2); i++){
			String s = "" + i;
			add(new JButton(s));
		}
		setLayout(tgLayout);
		
	}
}