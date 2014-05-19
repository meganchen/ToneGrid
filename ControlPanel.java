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
	private TGPlayer tgp;
	private JButton clear, start, pause, save, load, selectMode;
	private JTextField saveTextBox;
	private JComboBox loadBox, modeBox;
	
	//constructor
	public ControlPanel(ToneGrid t, TGPlayer player){
		tg = t;
		tgp = player;

		ButtonListener blistener = new ButtonListener();

		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(110, 30));
		clear.addActionListener(blistener);

		start = new JButton("Start");
		start.setPreferredSize(new Dimension(110, 30));
		start.addActionListener(blistener);

		pause = new JButton("Pause");
		pause.setPreferredSize(new Dimension(110, 30));
		start.addActionListener(blistener);

		save = new JButton("Save");
		save.setPreferredSize(new Dimension(110, 30));
		save.addActionListener(blistener);

		load = new JButton("Load");
		load.setPreferredSize(new Dimension(110, 30));
		load.addActionListener(blistener);

		saveTextBox = new JTextField("Enter name");
		saveTextBox.setPreferredSize(new Dimension(110, 30));

		setPreferredSize(new Dimension(365,120));
		setBackground(Color.GRAY);

		String[] loads = {"Demo"}; //dummy tester
		loadBox = new JComboBox(loads);
		loadBox.setPreferredSize(new Dimension(110, 30));

		String[] modes = {"Mode 1", "Mode 2", "Mode 3"};
		modeBox = new JComboBox(modes);
		modeBox.setPreferredSize(new Dimension(110, 30));
		modeBox.addActionListener(blistener);

		add(start); add(pause); add(clear);
		add(modeBox); add(saveTextBox); add(loadBox);
		add(save); add(load);
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getSource() == clear){
				tg.clear();
				ToneGridPanel.setBoxes();
			}
			else if(event.getSource() == save){
				String s = "" + saveTextBox.getText();
				boolean saved = tg.save(s);	
				//adds the name of the ToneGrid to the load combo box if grid is saved successfully
				if(saved){
					loadBox.addItem(saveTextBox.getText());
				}
			}
			else if(event.getSource() == load){
				tg.clear();
				System.out.println(loadBox.getSelectedItem());
				tg.load((String)loadBox.getSelectedItem());
				ToneGridPanel.setBoxes();
			}
			else if(event.getSource() == modeBox){
				System.out.println(modeBox.getSelectedItem());
				tgp.setMode((String)modeBox.getSelectedItem()); 

			}
			else if(event.getSource() == start){
				System.out.println("starting");
				tgp.loop();
			}
		}	
	}

}