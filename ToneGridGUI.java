/* ToneGridGUI.java
*
	Date Created: May 16, 2014
	Creator: Megan Chen
*/

import javax.swing.JFrame;

public class ToneGridGUI{
	
	public ToneGridGUI(){
		//heyo probs not necessary
	}
	
	public static void main(String[]args){
		JFrame frame = new JFrame("Tone Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ToneGridPanel tgp = new ToneGridPanel();
		frame.add(tgp);

		frame.pack();
		frame.setVisible(true);
	}

}