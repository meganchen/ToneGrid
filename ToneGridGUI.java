/* ToneGridGUI.java
* Creates the graphical user interface of the the ToneGrid. Adds ToneGridPanel and AboutPanel to separate tabs in the window.
	Date Created: May 16, 2014
	Authors: Megan Chen and Galen Chuang (TabbedPane)
*/

import javax.swing.*;
import java.awt.*;

public class ToneGridGUI {
	public static void main(String[] args){
		JFrame frame = new JFrame("Tone Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		ToneGrid tg = new ToneGrid();
		TGPlayer player = new TGPlayer("Mode 1", tg); //default mode is Mode 1
		ToneGridPanel tgp = new ToneGridPanel(tg, player);
		AboutPanel ap = new AboutPanel();

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("ToneGrid", tgp);
		tabbedPane.addTab("About", ap);

		frame.add(tabbedPane);
		frame.pack();
		frame.setVisible(true);
	}

}