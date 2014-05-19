/*ControlPanel class. 
Controls the clear, play, pause, select mode, save, and load buttons.

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
	private JButton clear, play, pause, save, load, selectMode;
	private JTextField saveTextBox;
	private JComboBox loadBox, modeBox;
	private Thread gridThread;
	private boolean gridPlaying; //tells whether or not the ToneGrid is currently playing
	
	//constructor
	public ControlPanel(ToneGrid t, TGPlayer player){
		setPreferredSize(new Dimension(365,120));
		setBackground(new Color(0x3B3B3B));
		
		tg = t;
		tgp = player;
		createGridThread();
		gridPlaying = false;

		ButtonListener blistener = new ButtonListener();

		clear = new JButton("Clear");
		clear.setPreferredSize(new Dimension(100, 25));
		clear.addActionListener(blistener);

		play = new JButton("Play");
		play.setPreferredSize(new Dimension(100, 25));
		play.addActionListener(blistener);

		pause = new JButton("Pause");
		pause.setPreferredSize(new Dimension(100, 25));
		pause.addActionListener(blistener);

		save = new JButton("Save");
		save.setPreferredSize(new Dimension(80, 25));
		save.addActionListener(blistener);

		load = new JButton("Load");
		load.setPreferredSize(new Dimension(80, 25));
		load.addActionListener(blistener);

		saveTextBox = new JTextField("Enter project name");
		saveTextBox.setPreferredSize(new Dimension(220, 25));

		String[] loads = {"-Saved Projects-"}; //dummy tester
		loadBox = new JComboBox(loads);
		loadBox.setPreferredSize(new Dimension(220, 25));

		String[] modes = {"-Select Mode-", "Mode 1", "Mode 2"};
		modeBox = new JComboBox(modes);
		modeBox.setPreferredSize(new Dimension(150, 25));
		modeBox.addActionListener(blistener);

		add(play); add(pause); add(clear);
		add(modeBox); 
		add(saveTextBox); add(save); 
		add(loadBox); add(load);
	}
	
	/*createGridThread method. Creates a new thread for playing the ToneGrid
	*/
	protected void createGridThread(){
		gridThread = new Thread(new Runnable(){ 
			public void run(){
				gridThread = Thread.currentThread();
				tgp.loop();
			}
			public void stop(){
				gridThread = null;
			}
		});
	}
	
	/*ButtonListener class*/
	private class ButtonListener implements ActionListener{
		public void actionPerformed (ActionEvent event){
			if(event.getSource() == clear){
				tg.clear();
				ToneGridPanel.setBoxes();
				MessagePanel.setMsg("Grid cleared.");
			}
			else if(event.getSource() == save){
				String s = "" + saveTextBox.getText();
				boolean saved = tg.save(s);	
				//adds the name of the ToneGrid to the load combo box if grid is saved successfully
				if(saved){
					loadBox.addItem(s);
					MessagePanel.setMsg(s + " saved.");
				}
				else{
					MessagePanel.setMsg("Save Error: " + s + " already exists.");
				}
			}
			else if(event.getSource() == load){
				tg.clear();
				String loadedGrid = (String)loadBox.getSelectedItem();
				System.out.println(loadedGrid);
				tg.load(loadedGrid);
				ToneGridPanel.setBoxes();
				MessagePanel.setMsg(loadedGrid + " loaded.");
			}
			else if(event.getSource() == modeBox){
				String modeSelected = (String)modeBox.getSelectedItem();
				System.out.println(modeSelected);
				tgp.setMode(modeSelected);
				MessagePanel.setMsg(modeSelected + " selected.");
			}
			else if(event.getSource() == play){
				if(!gridPlaying){
					createGridThread();
					gridThread.start(); //thread starts playing the ToneGrid
					gridPlaying = true;
					MessagePanel.setMsg("Playing grid");
				}
				else{
					System.out.println("Input Error: Grid Already Playing");
					MessagePanel.setMsg("Grid is already playing");
				}
			}
			else if(event.getSource() == pause){
				gridThread.stop();
				gridPlaying = false;
				MessagePanel.setMsg("Grid paused");
			}
		}	
	}
}