/*FooterPanel.java. Creates the footer text at the bottom of the ToneGrid with credits to the creators and Andre Michelle, whose ToneMatrix inspired this project.

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
		
		JLabel foot = new JLabel("Created by Megan Chen and Galen Chuang. Based on ToneMatrix by Andre Michelle.");
		foot.setForeground(new Color(0x8C8C8C));
		foot.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		add(foot);
	}
}