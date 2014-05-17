/* ToneGridGUI.java
*
	Date Created: May 16, 2014
	Creator: Megan Chen
*/

import javax.swing.JFrame;

//remove
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ToneGridGUI {
	
	public static void main(String[]args){
		JFrame frame = new JFrame("Tone Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		ToneGridPanel tgp = new ToneGridPanel();
		frame.add(tgp);

		frame.pack();
		frame.setVisible(true);
	}

}