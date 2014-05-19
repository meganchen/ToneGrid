/*FooterPanel.java 

Date Created: May 19, 2014
Author: Megan Chen
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FooterPanel extends JPanel{
	public FooterPanel(){
		setPreferredSize(new Dimension(600,20));
		setBackground(Color.BLACK);
		
		JLabel title = new JLabel("Created by Megan Chen and Galen Chuang. Based on ToneMatrix by Andre Michelle.");
		title.setForeground(new Color(0x8C8C8C));
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		add(title);
	}
}