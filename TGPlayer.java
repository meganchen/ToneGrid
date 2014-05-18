/**Tones class. Contains LinkedList of string of notes in each column. ex: "A6 E6 G6 C7"

Author: Galen Chuang
Date Created: May 13, 2014
**/
 
import org.jfugue.*;
import java.util.*;

public class TGPlayer {
	private LinkedList<String> scale; //holds the notes for three scales:
										//mode1 (major pent): CDFGACDFGACDFGAC
										//mode2 (minor pent): CDEGACDEGACDEGAC
										//mode3 (idk): CD#FG#A#CD#FG#A#CD#FG#A#C
	private ToneGrid tg;
	private Player p;
	private boolean play;

	public TGPlayer(String scaleInput, ToneGrid tg) {
		scale = new LinkedList<String>();
		p = new Player();
		play = false;
		
		if(scaleInput.equals("mode3")){
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
			scale.add("C8"); scale.add("A7"); scale.add("G7"); scale.add("F7");
			scale.add("D7"); scale.add("C7"); scale.add("A6"); scale.add("G6");  
			scale.add("F6"); scale.add("D6"); scale.add("C6"); scale.add("A5");  
			scale.add("G5"); scale.add("F5"); scale.add("D5"); scale.add("C5");
		}
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
		this.tg = tg;
	}

	//creates a player to play the whole column of notes, specified by the vertical booleans in LinkedList
	public void play(int column) {
		String s = "I[Xylophone] ";
		LinkedList<Integer> notes = tg.colTraverse(column);
		for(int i = 0; i < notes.size(); i++){
			s += scale.get(notes.get(i)) + "s";
			if(i+1 < notes.size())
				s+= "+";
		}
		System.out.println(s);
		p.play(s);
	}
	
	/*playGrid() tester method. Plays the entire grid once.
	*/
	public void playGrid(){
		for(int i = 0; i < ToneGrid.GRID_DIMENSION ; i++){
			play(i);
		}
	}
	
	/*loop method. Plays through the grid in a loop.
	*/		
	public void loop(){
		play = true;
		int i = 0;
		while(play){
			i++;
			for(int j = 0; j > -1; j++){
				j %= tg.GRID_DIMENSION;
				play(j);
			}
			if(i == 3)
				play = false;
		}
	}

}