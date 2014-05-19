/*MessagePanel. Creates a title for the ToneGridPanel

Date Created: May 19, 2014
Author: Megan Chen
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MessagePanel extends JPanel{
	private static JLabel msg;
	
	public MessagePanel(){
		setPreferredSize(new Dimension(450,25));
		setBackground(Color.BLACK);
		
		msg = new JLabel("Welcome to ToneGrid! To start, select boxes and press \"Play\"");
		msg.setForeground(new Color(0xBABABA));
		msg.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(msg);
	}
	
	/*setMsg method(). Gives the msg JLabel a new message to display.
	*@param message the new message
	*/
	public static void setMsg(String message){
		msg.setText(message);
	}
}