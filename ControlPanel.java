/*ControlPanel class. 
Controls the clear, start, pause, select mode, save, and load buttons.

Date Created: May 17, 2014
Author: Megan Chen
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ControlPanel extends JPanel{
	private ToneGrid tg;
	//private Hashtable<String, LinkedList<LinkedList<Boolean>>> hash;
	private JButton clear, save, load;
	private JTextField saveTextBox;
	
	//constructor
	public ControlPanel(ToneGrid t){
		tg = t;
		clear = new JButton("Clear");
		save = new JButton("Save");
		load = new JButton("Load");
		saveTextBox = new JTextField("Enter name");
		setPreferredSize(new Dimension(370,100));
		setBackground(Color.GRAY);
			
		add(load);
		add(saveTextBox);
		add(save);
		add(clear);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getSource() == clear)
				tg.clear();
			else if(event.getSource() == save){
				String s = "" + saveTextBox.getText();
				tg.save(s);
			}
			else if(event.getSource() == load)
				tg.load("wut");
		}
	}

}