/*AboutPanel. Displays information about how to use the ToneGrid.

Date Created: May 19, 2014
Authors: Galen Chuang (primary), Megan Chen (editing about text and adding the footer)
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AboutPanel extends JPanel{
	public AboutPanel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(370,520));

		JLabel title = new JLabel("About ToneGrid");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Lucida Grande", Font.BOLD, 20));

		JTextArea about = new JTextArea("\n Create cool music effortlessly with ToneGrid!\n\n Begin by selecting some gray boxes and pressing \"Play.\" Boxes\n can be selected at any time, even while ToneGrid is playing. Each\n row represents a certain pitch, and each column represents a\n different beat. Selecting a different mode changes the ToneGrid's\n musical scale. To save your project, enter its name into the\n textbox, and press \"Save.\" To load a saved project, select\n its name from the drop down menu, and press \"Load.\"");
		about.setPreferredSize(new Dimension(550,530));
		about.setForeground(Color.WHITE);
		about.setBackground(Color.BLACK);
		about.setFont(new Font("Lucinda Grande", Font.PLAIN, 16));
		about.setLineWrap(true);
		about.setWrapStyleWord(true);
		about.setEditable(false);
		
		FooterPanel foot = new FooterPanel();

		add(title);
		add(about);
		add(foot);
	}
}