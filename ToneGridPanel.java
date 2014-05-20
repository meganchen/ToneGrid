/*ToneGridPanel class. 
Places the TitlePanel, GridPanel, ControlPanel, MessagePanel, and FooterPanel into a single panel.

Date Created: May 17, 2014
Author: Megan Chen
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToneGridPanel extends JPanel{
	private static ToneGrid tg;
	private static TGPlayer tgp;
	private static GridPanel gp;

	//constructor
	public ToneGridPanel(ToneGrid t, TGPlayer player){
		setPreferredSize(new Dimension(600,600));
		setBackground(Color.BLACK);
		
		tg = t;
		tgp = player;
		gp = new GridPanel(tg, tgp);
		
		ControlPanel cp = new ControlPanel(tg, tgp);
		TitlePanel title = new TitlePanel();
		MessagePanel msg = new MessagePanel();
		FooterPanel fp = new FooterPanel();
		
		add(title);
		add(gp);
		add(msg);
		add(cp);
		add(fp);
	}
	
	/*setBoxes method.
	* Sets the grid in the GridPanel to the state current of the ToneGrid
	*/
	public static void setBoxes(){
		gp.setBoxes();
	}
	
}