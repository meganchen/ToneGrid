/**Tones class. Contains LinkedList of string of notes in each column. ex: "A6 E6 G6 C7"

Author: Galen Chuang
Date Created: May 13, 2014
**/
 
import org.jfugue.*;
import java.util.*;

public class TGPlayer {
	private static LinkedList<String> scale; //holds the notes for three scales:
										//mode1 (major pent): CDFGACDFGACDFGAC
										//mode2 (minor pent): CDEGACDEGACDEGAC
										//mode3 (idk): CD#FG#A#CD#FG#A#CD#FG#A#C
	private Player p;
	private ToneGrid tg;

	public TGPlayer(String scaleInput, ToneGrid toneGrid) {
		scale = new LinkedList<String>();
		p = new Player();
		tg = toneGrid;
		setMode("Mode 1");
		
		/*if(scaleInput.equals("mode3")){
			scale.add("C5"); scale.add("D#5"); scale.add("F5"); scale.add("G#5"); 
			scale.add("A#5"); scale.add("C6"); scale.add("D#6"); scale.add("F6"); 
			scale.add("G#6"); scale.add("A#6"); scale.add("C7"); scale.add("D#7"); 
			scale.add("F7"); scale.add("G#7"); scale.add("A#7"); scale.add("C8");
		}		
		else if(scaleInput.equals("mode2")){
			scale.add("C5"); scale.add("D5"); scale.add("E5"); scale.add("G5");
			scale.add("A5"); scale.add("C6"); scale.add("D6"); scale.add("E6"); 
			scale.add("G6"); scale.add("A6"); scale.add("C7"); scale.add("D7"); 
			scale.add("E7"); scale.add("G7"); scale.add("A7"); scale.add("C8");	
		}
		else if(scaleInput.equals("mode1")){
			scale.add("C5"); scale.add("D5"); scale.add("F5"); scale.add("G5"); 
			scale.add("A5"); scale.add("C6"); scale.add("D6"); scale.add("F6"); 
			scale.add("G6"); scale.add("A6"); scale.add("C7"); scale.add("D7"); 
			scale.add("F7"); scale.add("G7"); scale.add("A7"); scale.add("C8"); 
		}*/
	}

	//creates a player to play the whole column of notes, specified by the vertical booleans in LinkedList
	public void play(int column) {
		p = new Player();
		String s = "I[Xylophone] ";
		LinkedList<Integer> notes = tg.colTraverse(column);
		System.out.println("notes: " + notes);
		System.out.println("empty: " + notes.isEmpty());
		if (notes.isEmpty()){
			s = "Rs";
		}
		else{
			for(int i = 0; i < notes.size(); i++){
					s += scale.get(notes.get(i)) + "s";
					if(i+1 < notes.size())
						s += "+";
			}
		}
		System.out.println(s  + "\n-----");
		p.play(s);
		p.close();
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
		the specified scale. The options are mode1, mode2, mode3.*/	
	public static void setMode(String modeInput) {
		scale.clear();
		if(modeInput.equals("Mode 1")){
			scale.add("C8"); scale.add("A7"); scale.add("G7"); scale.add("F7");
			scale.add("D7"); scale.add("C7"); scale.add("A6"); scale.add("G6");  
			scale.add("F6"); scale.add("D6"); scale.add("C6"); scale.add("A5");  
			scale.add("G5"); scale.add("F5"); scale.add("D5"); scale.add("C5");
		}
		else if(modeInput.equals("Mode 2")){
			scale.add("C8"); scale.add("A7"); scale.add("G7"); scale.add("E7"); 
			scale.add("D7"); scale.add("C7"); scale.add("A6"); scale.add("G6"); 
			scale.add("E6"); scale.add("D6"); scale.add("C6"); scale.add("A5");
			scale.add("G5"); scale.add("E5"); scale.add("D5"); scale.add("C5"); 	
		}
		else if(modeInput.equals("Mode 3")){
			scale.add("C8"); scale.add("A#7"); scale.add("G#7"); scale.add("F7"); 
			scale.add("D#7"); scale.add("C7"); scale.add("A#6"); scale.add("G#6"); 
			scale.add("F6"); scale.add("D#6"); scale.add("C6"); scale.add("A#5");  
			scale.add("G#5"); scale.add("F5"); scale.add("D#5"); scale.add("C5"); 
		}		
		else{
			System.out.println("Choose Mode 1, Mode 2, or Mode 3.");
		}
	}
	
	/*loop method. Plays through the grid in a loop.
	*/		
	public void loop(){
		int i = 0;
		while(true){
			play(i % ToneGrid.GRID_DIMENSION);
			i++;
		}
	}
	
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
		/*tgp.play(1);
		tgp.play(2);
		tgp.play(1);
		tgp.play(2);

		tgp.play(5);
		tgp.play(6);
		tgp.play(5);
		tgp.play(6);
		
		tgp.play(1);
		tgp.play(2);
		tgp.play(1);
		tgp.play(2);
		
		tgp.play(5);
		tgp.play(6);
		tgp.play(5);
		tgp.play(6);
		
		tgp.play(1);
		tgp.play(2);
		tgp.play(1);
		tgp.play(2);

		tgp.play(5);
		tgp.play(6);
		tgp.play(5);
		tgp.play(6);
		
		tgp.play(1);
		tgp.play(2);
		tgp.play(1);
		tgp.play(2);
		
		tgp.play(5);
		tgp.play(6);
		tgp.play(5);
		tgp.play(6);
		*/
		
	}
}