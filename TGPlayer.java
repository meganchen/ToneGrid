/**TGPlayer class. Contains LinkedList of string of notes in each column. ex: "A6 E6 G6 C7"

Author: Galen Chuang (primary), Megan Chen
Date Created: May 13, 2014
**/
 
import org.jfugue.*;
import java.util.*;

public class TGPlayer {
	private static LinkedList<String> scale; //holds the notes for three scales:
										//mode1 (major pent in C): CDFGACDFGACDFGAC
										//mode2 (idk in C): CD#FG#A#CD#FG#A#CD#FG#A#C
										//mode3 (major pent in G): GABDEGABDEGABDEG
	private Player p;
	private ToneGrid tg;
	
	/*TGPlayer constructor
	*@param scaleInput either "Mode 1" or "Mode 2"
	*@param toneGrid the ToneGrid to play
	*/
	public TGPlayer(String scaleInput, ToneGrid toneGrid) {
		scale = new LinkedList<String>();
		p = new Player();
		tg = toneGrid;
		setMode(scaleInput); //sets the default scale to scaleInput
	}
	
	/*playGrid() tester method. Plays the entire grid once. 
	* NOTE: not used in implementation of ToneGrid
	*/
	public void playGrid(){
		for(int i = 0; i < ToneGrid.GRID_DIMENSION ; i++){
			play(i);
		}
	}
	
	/*setMode() setter. Sets the scale LinkedList<String> instance variable to
		the specified scale. The options are "Mode 1", "Mode 2", or "Mode 3".
	@param modeInput the mode that the ToneGrid will play
	*/	
	public static void setMode(String modeInput) {
		if(modeInput.equals("Mode 1")){
			scale.clear();
			scale.add("C8"); scale.add("A7"); scale.add("G7"); scale.add("F7");
			scale.add("D7"); scale.add("C7"); scale.add("A6"); scale.add("G6");  
			scale.add("F6"); scale.add("D6"); scale.add("C6"); scale.add("A5");  
			scale.add("G5"); scale.add("F5"); scale.add("D5"); scale.add("C5");
		}
		/*old mode 2
			else if(modeInput.equals("Mode 2")){
			scale.add("C8"); scale.add("A7"); scale.add("G7"); scale.add("E7"); 
			scale.add("D7"); scale.add("C7"); scale.add("A6"); scale.add("G6"); 
			scale.add("E6"); scale.add("D6"); scale.add("C6"); scale.add("A5");
			scale.add("G5"); scale.add("E5"); scale.add("D5"); scale.add("C5"); 	
		}*/
		else if(modeInput.equals("Mode 2")){
			scale.clear();
			scale.add("C8"); scale.add("A#7"); scale.add("G#7"); scale.add("F7"); 
			scale.add("D#7"); scale.add("C7"); scale.add("A#6"); scale.add("G#6"); 
			scale.add("F6"); scale.add("D#6"); scale.add("C6"); scale.add("A#5");  
			scale.add("G#5"); scale.add("F5"); scale.add("D#5"); scale.add("C5"); 
		}		
		else if(modeInput.equals("Mode 3")) {
			scale.clear();
			scale.add("G8"); scale.add("E7"); scale.add("D7"); scale.add("B7");
			scale.add("A7"); scale.add("G7"); scale.add("E6"); scale.add("D6");  
			scale.add("B6"); scale.add("A6"); scale.add("G6"); scale.add("E5");  
			scale.add("D5"); scale.add("B5"); scale.add("A5"); scale.add("G5");
		}
		else{
			System.out.println("Select Mode 1, Mode 2, or Mode 3.");
		}
	}
	
	/*creates a player to play the whole column of notes, specified by the vertical booleans in LinkedList
	*@param column the column that is being played
	*/
	public void play(int column) {
		p = new Player();
		String s = "I[Xylophone] "; //uses the jfugue xylophone to play the notes
		LinkedList<Integer> notes = tg.colTraverse(column); //returns all true (selected) boxes in the column
		GridPanel.setColor(column, notes, "blue"); //sets the color of the true boxes to blue while they're being played
		//code that prints information about the played column in the console for testing
		System.out.println("notes: " + notes);
		System.out.println("empty: " + notes.isEmpty());
		if (notes.isEmpty()){ //if no notes are selected, play a rest
			s += "X[Volume]=0 C5maj7s"; //plays a chord with volume zero. acts as a rest for empty columns
		}
		else{
			//for all notes that are selected, create a string representation of the selected notes for the Player
			for(int i = 0; i < notes.size(); i++){
					s += scale.get(notes.get(i)) + "s";
					if(i+1 < notes.size())
						s += "+";
			}
		}
		System.out.println(s  + "\n-----");
		p.play(s); //plays the notes that are selected
		p.close(); //closes the Player
		GridPanel.setColor(column, notes, "yellow"); //resets color of selected boxes to yellow
	}
	
	/*loop method. Plays through the grid in an infinite loop.
	*/		
	public void loop(){
		int i = 0;
		while(true){
			System.out.println("Note #" + i);
			play(i % tg.GRID_DIMENSION);
			i++;
		}
	}
	
	/*main method. Tests the TGPlayer class*/
	public static void main(String[]args){
		ToneGrid tg = new ToneGrid();
		TGPlayer tgp = new TGPlayer("Mode 1", tg);
		for(int i = 0; i < ToneGrid.GRID_DIMENSION; i++){
			tg.toggle(i,i);
			tg.toggle(i, (i + 2) % ToneGrid.GRID_DIMENSION);
			tg.toggle(i, (i + 3) % ToneGrid.GRID_DIMENSION);
			tg.toggle(i, (i + 12) % ToneGrid.GRID_DIMENSION);
			tg.toggle(i, (i + 13) % ToneGrid.GRID_DIMENSION);
		}
		System.out.println(tg);
		//tgp.playGrid();
		tgp.loop();
		
	}
}