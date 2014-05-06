/**ToneGrid class. Contains the LinkedLists that keep track of which notes are selected in the tone grid.

Author: Megan Chen
Date Created: May 6, 2014
**/

import java.util.*;
public class ToneGrid{
	
	private LinkedList<LinkedList<Boolean>> beats;
	private LinkedList<Boolean> notes;
	private final boolean FALSE = false;
	private final int GRID_DIMENSION = 16; 
	
	/*ToneGrid constructor. Instantiates a 16x16 ToneGrid and the default value of each node is FALSE.
	*/
	public ToneGrid(){
		beats = new LinkedList<LinkedList<Boolean>>();
		notes = new LinkedList<Boolean>();
		
		while(notes.size() < GRID_DIMENSION){
			notes.add(FALSE);
		}
		
		while(beats.size() < GRID_DIMENSION){
			beats.add(notes);
		}
		
	}
	/*toString()
	*@returns a string representation of the Tone Grid
	*/
	public String toString(){
		String s = "";
		//traverses the outer "beats" linked list of "notes" linked lists
		for(int i = 0; i < beats.size(); i++){
			//traverses the inner "notes" linked list of booleans
			for(int j = 0; j < notes.size(); j++){
				Boolean b = beats.get(i).get(j);
				if(b)
					s += "T ";
				else
					s += "F ";
			}
			s += "\n";
		}
		return s;
	}
	
	public static void main(String[]args){
		ToneGrid tg = new ToneGrid();
		System.out.println("Default ToneGrid:\n" + tg);
	}
}