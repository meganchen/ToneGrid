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
	private JButton clear, start, pause, save, load, selectMode;
	private JTextField saveTextBox;
	private JComboBox loadBox, modeBox;
	
	//constructor
	public ControlPanel(ToneGrid t){
		tg = t;

		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(110, 30));
		clear.addActionListener(new ButtonListener());

		start = new JButton("Start");
		start.setPreferredSize(new Dimension(110, 30));

		pause = new JButton("Pause");
		pause.setPreferredSize(new Dimension(110, 30));

		save = new JButton("Save");
		save.setPreferredSize(new Dimension(110, 30));
		save.addActionListener(new ButtonListener());

		load = new JButton("Load");
		load.setPreferredSize(new Dimension(110, 30));
		load.addActionListener(new ButtonListener());

		selectMode = new JButton("Select mode");
		selectMode.setPreferredSize(new Dimension(110, 30));

		saveTextBox = new JTextField("Enter name");
		saveTextBox.setPreferredSize(new Dimension(110, 30));

		setPreferredSize(new Dimension(365,120));
		setBackground(Color.GRAY);

		String[] loads = {"Test1", "Test2"}; //dummy tester
		loadBox = new JComboBox(loads);
		loadBox.setPreferredSize(new Dimension(110, 30));

		String[] modes = {"Mode 1", "Mode 2", "Mode 3"};
		modeBox = new JComboBox(modes);
		modeBox.setPreferredSize(new Dimension(110, 30));

		add(start); add(pause); add(clear);
		add(modeBox); add(saveTextBox); add(loadBox);
		add(selectMode); add(save); add(load);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getSource() == clear) {
				ToneGridPanel.clear();
			}
			else if(event.getSource() == save){
				String s = "" + saveTextBox.getText();
				tg.save(s);
				loadBox.addItem(saveTextBox.getText());
			}
			else if(event.getSource() == load) {
				tg.load((String)loadBox.getSelectedItem());
			}
		}	
	}

}