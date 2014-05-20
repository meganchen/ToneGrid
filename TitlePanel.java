/*TitlePanel. Creates a title for the ToneGridPanel

Date Created: May 19, 2014
Author: Megan Chen
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitlePanel extends JPanel{
	//TitlePanel() constructor
	public TitlePanel(){
		setPreferredSize(new Dimension(370,30));
		setBackground(Color.BLACK);
		
		JLabel title = new JLabel("ToneGrid");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		add(title);
	}
}