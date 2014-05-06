/**ToneGrid class. Contains the LinkedLists that keep track of which notes are selected in the tone grid.

Author: Megan Chen
Date Created: May 6, 2014
**/

import java.util.*;
public class ToneGrid{
	
	private LinkedList<LinkedList<Boolean>> beats;
	private final int GRID_DIMENSION = 16; 
	
	/*ToneGrid constructor. Instantiates a 16x16 ToneGrid and the default value of each node is FALSE.
	*/
	public ToneGrid(){
		beats = new LinkedList<LinkedList<Boolean>>();

		//adds GRID_DIMENSION nodes to the beats LinkedList
		for(int colCount = 0; beats.size() < GRID_DIMENSION; colCount++){
			//adds a LinkedList of Booleans at each node of the beats LinkedList
			beats.add(new LinkedList<Boolean>());
			LinkedList colList = beats.get(colCount);
			//populates the LinkedList of Booleans as FALSE
			while(colList.size() < GRID_DIMENSION)
				colList.add(false);
		}
		
	}
	
	/*toString()
	*@returns a string representation of the ToneGrid
	*/
	public String toString(){
		String s = "";
		
		//traverses the outer "beats" linked list of "notes" linked lists
		for(int i = 0; i < GRID_DIMENSION; i++){
			//traverses the inner "notes" linked list of booleans
			for(int j = 0; j < GRID_DIMENSION; j++){
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
	
	/*setTrue(). Sets a particular location in the ToneMatrix as TRUE.
	*@param numBeat beat number (index in "beats" LinkedList)
	*@param numNote note number (index in "notes" LinkedList)
	*/
	public void setTrue(int numBeat, int numNote){
		LinkedList colNotesList = beats.get(numBeat);
		colNotesList.set(numNote, true);
	}
	
	/*setFalse(). Sets a particular location in the ToneMatrix as FALSE.
	*@param numBeat beat number (index in "beats" LinkedList)
	*@param numNote note number (index in "notes" LinkedList)
	*/
	public void setFalse(int numBeat, int numNote){
		LinkedList colNotesList = beats.get(numBeat);
		colNotesList.set(numNote, false);
	}
	
	/* colTraverse method.
	*@param column number
	*@returns string of integers that tell which indexes in the notes LinkedList are true
	*/
	public String colTraverse(int colNum){
		String s = "";
		//check all elements of the "notes" LinkedList contained within the "beats" LinkedLists's node (nodeNum)
		for(int i = 0; i < GRID_DIMENSION; i++){
			//if the value is true, add the value's index in "notes" LinkedList to the string
			if(beats.get(colNum).get(i))
				s += i + " ";
		}
		return s;
	}
	
	public static void main(String[]args){
		ToneGrid tg = new ToneGrid();
		System.out.println("Default ToneGrid:\n" + tg);
		tg.setTrue(0,0);
		tg.setTrue(0,2);
		tg.setTrue(1,1);
		tg.setTrue(3,3);
		tg.setTrue(15,15);
		System.out.println("Get all true locations of beat/node 0 (Expect \"0 2\"): " + tg.colTraverse(0));
		System.out.println(tg);
		tg.setFalse(0,0);
		System.out.println(tg);
	}
}