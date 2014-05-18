import org.jfugue.*; 

public class MyMusicApp { 
	public static void main(String[] args) { 
		Player player = new Player(); 
		//Pattern pattern = new Pattern("");
 		//Pattern pattern = new Pattern("T[Grave] A6x G6x A6q G6t F6t E6t D6t C#6i D6i"); 
 		//player.play("T[Grave] A6x G6x A6q G6t F6t E6t D6t C#6i D6i");
 		player.play("T[Grave] I[Xylophone] C6t+D6t+A6t+G7t");
 		player.play("T[Grave] I[Xylophone] F6t+C7t+G6t+G7t");
 		player.play("T[Grave] I[Xylophone] C6t+D7t+A8t+C9t");
 		player.play("T[Grave] I[Xylophone] F6t+C7t+G6t+G7t+C8t");


 		//mode1 (major pent): C6 D6 F6 G6 A6 C7 D7 F7 G7 A7 C8 D8 F8 G8 A8 C9
 	} 
} 
