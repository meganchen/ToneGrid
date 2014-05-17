/*ControlPanel class. 
Controls the clear, start, pause, select mode, save, and load buttons.

Date Created: May 17, 2014
Author: Megan Chen
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToneGridPanel extends JPanel{
	private ToneGrid tg;

	//constructor
	public ToneGridPanel(ToneGrid t){
		tg = t;
		setPreferredSize(new Dimension(500,500));
		setBackground(Color.BLACK);
		
		GridPanel gp = new GridPanel(tg);
		ControlPanel cp = new ControlPanel(tg);
		
		add(gp);
		add(cp);
	}
}