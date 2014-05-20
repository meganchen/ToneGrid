/*ControlPanel class. 
Controls the clear, play, pause, select mode, save, and load buttons of the ToneGrid.

Date Created: May 17, 2014
Author: Megan Chen (primary), Galen Chuang
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
 
 /*ControlPanel constructor
 *@param t ToneGrid to control
 *@param player TGPlayer that plays the ToneGrid
 */
 public ControlPanel(ToneGrid t, TGPlayer player){
  setPreferredSize(new Dimension(365,120));
  setBackground(new Color(0x3B3B3B));
  
  tg = t;
  tgp = player;
  createGridThread(); //creates a thread that starts and stops the infinite loop playing the grid
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

  String[] loads = {"-Saved Projects-"};
  loadBox = new JComboBox(loads);
  loadBox.setPreferredSize(new Dimension(220, 25));

  String[] modes = {"-Select Mode-", "Mode 1", "Mode 2", "Mode 3"};
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
   //run method. runs the thread
   public void run(){
    gridThread = Thread.currentThread(); //sets the thread to the thread that's running the infinite loop
    tgp.loop();
   }
   //stop method. stops the thread
   public void stop(){
    gridThread = null; //sets the thread to null to pause playing the infinite loop
   }
  });
 }
 
 /*ButtonListener class. Creates listeners for the clear, play, pause, select mode, save, and load buttons
 */
 private class ButtonListener implements ActionListener{
  public void actionPerformed (ActionEvent event){
   if(event.getSource() == clear){ //controls the clear button
    tg.clear();
    ToneGridPanel.setBoxes();
    MessagePanel.setMsg("Grid cleared.");
   }
   else if(event.getSource() == save){ //controls the save button
    String s = "" + saveTextBox.getText();
    boolean saved = tg.save(s); 
    //adds the name of the ToneGrid to the "load" JComboBox if the ToneGrid is saved successfully
    if(saved){
     loadBox.addItem(s);
     MessagePanel.setMsg(s + " saved.");
    }
    else{ //if not, the MessagePanel gives and error to the user
     MessagePanel.setMsg("Save Error: " + s + " already exists.");
    }
   }
   else if(event.getSource() == load){ //controls the load button
    tg.clear();
    String loadedGrid = (String)loadBox.getSelectedItem();
    System.out.println(loadedGrid);
    tg.load(loadedGrid);
    ToneGridPanel.setBoxes();
    //Encourages the user to select an actual project if "-Saved Projects-" is selected
    if(loadedGrid.equals("-Saved Projects-"))
     MessagePanel.setMsg("Create and select a project to load.");
    else
     MessagePanel.setMsg(loadedGrid + " loaded.");
   }
   else if(event.getSource() == modeBox){ //controls the mode JComboBox
    String modeSelected = (String)modeBox.getSelectedItem();
    System.out.println(modeSelected);
    tgp.setMode(modeSelected);
    MessagePanel.setMsg(modeSelected + " selected.");
    //Encourages the user to select a mode. Default is "Mode 1"
    if(modeSelected.equals("-Select Mode-"))
     MessagePanel.setMsg("Please select a mode. Default mode is Mode 1");
    else
     MessagePanel.setMsg(modeSelected + " selected.");
   }
   else if(event.getSource() == play){ //controls the play button
    //if the grid is not playing, start playing the grid. This if-else statement prevents the creation of duplicate threads if the user presses play multiple times.
    if(!gridPlaying){
     createGridThread();
     gridThread.start(); //thread starts playing the ToneGrid
     gridPlaying = true;
     MessagePanel.setMsg("Playing grid");
    }
    else{ //grid doesn't do anything if it's already playing. 
     System.out.println("Input Error: Grid Already Playing");
     MessagePanel.setMsg("Grid is already playing");
    }
   }
   else if(event.getSource() == pause){ //controls the pause button
    gridThread.stop(); //stops the infinite loop thread playing the ToneGrid
    ToneGridPanel.setBoxes();
    gridPlaying = false;
    MessagePanel.setMsg("Grid paused");
   }
  } 
 }

}