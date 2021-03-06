/**ToneGrid class. Contains the LinkedList of LinkedList<Boolean>s that keep track of which notes are selected in the ToneGrid. Includes methods to manipulate (toggle() between true and false) locations in the ToneGrid, and return information about different locations in the grid(specific boxes, columns),  play sounds according to the boolean values stored in the LinkedLists, and save/load/clear the state ToneGrid.

Author: Megan Chen (primary) and Galen Chuang (setMode method)
Date Created: May 6, 2014
**/

import java.util.*;
public class ToneGrid{
	
	private LinkedList<LinkedList<Boolean>> beats;
	private Hashtable<String, LinkedList<LinkedList<Boolean>>> grids;
	public static final int GRID_DIMENSION = 16;
	
	/*ToneGrid constructor. Instantiates a 16x16 ToneGrid and the default value of each node is FALSE.
	*/
	public ToneGrid(){
		beats = new LinkedList<LinkedList<Boolean>>();
		grids = new Hashtable<String, LinkedList<LinkedList<Boolean>>>();
		
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
				Boolean b = getBool(j,i);
				if(b) //if the stored value is true, print "T"
					s += "T ";
				else //if the stored value is true, print "-"
					s += "- ";
			}
			s += "\n";  //at the end of each row, go to the next line
		}
		return s;
	}
	
	/*getCol().
	*@param numBeat beat number (index in "beats" LinkedList)
	*@returns the LinkedList contained within a node of the "beats" LinkedList
	*/
	public LinkedList<Boolean> getCol(int numBeat){
		return beats.get(numBeat);
	}
	
	/*getBool(). Gets the boolean value of a particular location in the ToneGrid
	*@param numBeat beat number (index in "beats" LinkedList) [col]
	*@param numNote note number (index in "notes" LinkedList) [row]
	*@return the location's value (true/false)
	*/
	public boolean getBool(int numBeat, int numNote){
		return getCol(numBeat).get(numNote);
	}
	
	/*setTrue(). Sets the note at a particular location in the ToneGrid as true.
	*@param numBeat beat number (index in "beats" LinkedList) [col]
	*@param numNote note number (index in "notes" LinkedList) [row]
	*/
	public void setTrue(int numBeat, int numNote){
		getCol(numBeat).set(numNote, true);
	}
	
	/*setFalse(). Sets a particular location in the ToneGrid as false.
	*@param numBeat beat number (index in "beats" LinkedList) [col]
	*@param numNote note number (index in "notes" LinkedList) [row]
	*/
	public void setFalse(int numBeat, int numNote){
		getCol(numBeat).set(numNote, false);
	}
	
	/*clear(). Resets all values in the ToneGrid to false
	*/
	public void clear(){
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
	
	/*toggle(). Switches between true and false
	*@param numBeat beat number (index in "beats" LinkedList) [col]
	*@param numNote note number (index in "notes" LinkedList) [row]
	*/
	public void toggle(int numBeat, int numNote){
		//if true, set as false
		if(getBool(numBeat, numNote))
			setFalse(numBeat, numNote);
		else //if false, set as true
			setTrue(numBeat,numNote);
	}
	
	/* colTraverse method.
	*@param column number
	*@returns LinkedList<Integer> of integers that tell which indexes in the notes LinkedList are true
	*/
	public LinkedList<Integer> colTraverse(int colNum){
		LinkedList<Integer> s = new LinkedList<Integer>();
		//check all elements of the "notes" LinkedList contained within the "beats" LinkedLists's node (nodeNum)
		for(int i = 0; i < GRID_DIMENSION; i++){
			//if the value is true, add the value's index in "notes" LinkedList to the string
			if(beats.get(colNum).get(i))
				s.add(i);
		}
		return s;
	}
	
	/* save method. Save the current state of the ToneGrid to the grids Hashtable
	*@param tgName the name under which the ToneGrid will be saved.
	*@return true if the save was successful, false if not.
	*Precondition: tgName doesn't already exist. If tgName already exists, program will print a message.
	*/
	public Boolean save(String tgName){
		//if tgName doesn't exist in grids Hashtable, add to grid. and returns true
		if(grids.get(tgName) == null){
			grids.put(tgName, beats);
			return true;
		}
		else //if exists, print error message and returns false
			System.out.println("Save Error: " + tgName + " already exists.");
		return false;
	}
	
	/*load method. Loads a grid that has been saved and sets it as the current grid.
	*@param tgName the name of the saved ToneGrid
	*Precondition: tgName exists. If tgName doesn't exist, program will print a message.
	*/
	public void load(String tgName){
		//if tgName key exists in grids Hashtable, load it
		if(grids.get(tgName) != null)
			beats = grids.get(tgName);
		else //if doesn't exist, print error message
			System.out.println("Load Error: " + tgName + " does not exist.");
	}
	
	/*setMode method
	*@param modeInput the mode to play ["Mode 1", "Mode 2", or "Mode 3"]
	*/
	public void setMode(String modeInput) {
		TGPlayer.setMode(modeInput);
	}
	
	/*getGrids method. 
	*@return hashtable containing the saved grids
	*/	
	public Hashtable<String, LinkedList<LinkedList<Boolean>>> getGrids(){
		return grids;
	}
	
	/*main method. Tests code within this class*/
	public static void main(String[]args){
		ToneGrid tg = new ToneGrid();
		System.out.println("Default ToneGrid:\n" + tg);
		tg.setTrue(0,0);
		tg.setTrue(0,2);
		tg.setTrue(1,1);
		tg.setTrue(3,3);
		System.out.println("Get all true locations of beat/node 0 (Expect \"0 2\"): " + tg.colTraverse(0));
		System.out.println(tg);
		tg.setFalse(0,0);
		System.out.println("setFalse() Test at (0,0) (Expect \"F\"):\n" + tg);
		tg.toggle(0,0);
		System.out.println("Toggle Test at (0,0) (Expect \"T\"):\n" + tg);
		tg.toggle(0,0);
		System.out.println("Toggle Test at (0,0) (Expect \"F\"):\n" + tg);
		tg.clear();
		System.out.println("Clearing ToneGrid: \n" + tg);
		for(int i = 0; i < ToneGrid.GRID_DIMENSION; i++){
			tg.toggle(i,i);
		}
		System.out.println("Testing save method\n\"Tester 1\" ToneGrid: \n" + tg);
		tg.save("Tester 1");
		tg.clear();
		System.out.println("Clearing ToneGrid\n" + tg);
		for(int i = 0; i < ToneGrid.GRID_DIMENSION; i++){
			tg.toggle(0,i);
		}
		System.out.println("\"Tester 2\" ToneGrid: \n" + tg);
		tg.save("Tester 2");
		tg.clear();
		for(int i = 0; i < ToneGrid.GRID_DIMENSION; i++){
			tg.toggle(i,0);
		}
		System.out.println("\"Tester 3\" ToneGrid: \n" + tg);
		tg.save("Tester 3");
		tg.load("Tester 1");
		System.out.println("Loading \"Tester 1\":\n" + tg);
		tg.load("Tester 2");
		System.out.println("Loading \"Tester 2\":\n" + tg);
		tg.load("Tester 3");
		System.out.println("Loading \"Tester 3\":\n" + tg);
		
		tg.clear();
		tg.save("Tester 2");
		tg.load("Tester 2");
		System.out.println(tg);
		tg.load("TWiggles");
		tg.load("Tester 1");
		tg.toggle(0,3);
		tg.toggle(1,4);
		tg.toggle(2,5);
		tg.toggle(3,6);
		tg.toggle(4,7);
		tg.toggle(5,8);
		tg.toggle(6,9);
		tg.toggle(7,10);
		tg.toggle(8,11);
		tg.toggle(9,12);
		tg.toggle(10,13);
		tg.toggle(11,14);
		tg.toggle(12,15);
		TGPlayer player =  new TGPlayer("mode1", tg);
		System.out.println(tg);
		//player.playGrid();
		player.loop();
		
		
		
	}
}