/**Tones class. Contains LinkedList of string of notes in each column. ex: "A6 E6 G6 C7"

Author: Galen Chuang
Date Created: May 13, 2014
**/

//package org.jfugue; 
import java.util.*;

public class TGPlayer {
	//private LinkedList<String> notes; //each node represents a column - string of patterns in JFugue
	//private LinkedList<String> scale; //holds the notes for three scales:
										//mode1 (major pent): CDFGACDFGACDFGAC
										//mode2 (minor pent): CDEGACDEGACDEGAC
										//mode3 (idk): CD#FG#A#CD#FG#A#CD#FG#A#C
	private String[] scale;
	private ToneGrid tg;

	public TGPlayer(String scaleInput, ToneGrid tg) { //add more notes when grid dimension is bigger
		scale = new String[ToneGrid.GRID_DIMENSION];

		//if (scaleInput.equals("mode1")) {
			scale[0] = "C5"; scale[1] = "D5"; scale[2] = "F5"; scale[3] = "G5"; 
			scale[4] = "A5"; scale[0] = "C6"; scale[1] = "D6"; scale[2] = "F6"; 
			scale[3] = "G6"; scale[4] = "A6"; 
			//}
		/*if (scaleInput == mode2) {
			scale.add("C5"); scale.add("D5"); scale.add("E5"); scale.add("G5");
			scale.add("A5"); scale.add("C6"); scale.add("D6"); scale.add("E6"); 
			scale.add("G6"); scale.add("A6"); scale.add("C7"); scale.add("D7"); 
			scale.add("E7"); scale.add("G7"); scale.add("A7"); scale.add("C8");	
		}

		if (scaleInput == mode3) {
			scale.add("C5"); scale.add("D#5"); scale.add("F5"); scale.add("G#5"); 
			scale.add("A#5"); scale.add("C6"); scale.add("D#6"); scale.add("F6"); 
			scale.add("G#6"); scale.add("A#6"); scale.add("C7"); scale.add("D#7"); 
			scale.add("F7"); scale.add("G#7"); scale.add("A#7"); scale.add("C8");
		}*/

		//assigning linkedlists
		/*if (scaleInput == mode1) {
			scale.add("C5"); scale.add("D5"); scale.add("F5"); scale.add("G5"); 
			scale.add("A5"); scale.add("C6"); scale.add("D6"); scale.add("F6"); 
			scale.add("G6"); scale.add("A6"); scale.add("C7"); scale.add("D7"); 
			scale.add("F7"); scale.add("G7"); scale.add("A7"); scale.add("C8");
		}
		if (scaleInput == mode2) {
			scale.add("C5"); scale.add("D5"); scale.add("E5"); scale.add("G5");
			scale.add("A5"); scale.add("C6"); scale.add("D6"); scale.add("E6"); 
			scale.add("G6"); scale.add("A6"); scale.add("C7"); scale.add("D7"); 
			scale.add("E7"); scale.add("G7"); scale.add("A7"); scale.add("C8");	
		}

		if (scaleInput == mode3) {
			scale.add("C5"); scale.add("D#5"); scale.add("F5"); scale.add("G#5"); 
			scale.add("A#5"); scale.add("C6"); scale.add("D#6"); scale.add("F6"); 
			scale.add("G#6"); scale.add("A#6"); scale.add("C7"); scale.add("D#7"); 
			scale.add("F7"); scale.add("G#7"); scale.add("A#7"); scale.add("C8");
		}*/

		this.tg = tg;
	}

	//creates a player to play the whole column of notes, specified by the vertical booleans in LinkedList
	public void play(int column) {
		String s = "I[Xylophone] ";
		org.jfugue.Player p = new org.jfugue.Player();
		for(int i = 0; i < ToneGrid.GRID_DIMENSION; i++){
				Boolean b = tg.getBool(column,i);
				if(b)
					s += scale[i] + "s+";
		}
		//System.out.println(s);
		p.play(s);
	}

}