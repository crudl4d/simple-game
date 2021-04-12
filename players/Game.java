package players;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import statistics.NullStatistics;
import statistics.Statistics;

public class Game {

    private List<Player> players = new ArrayList<>();
    private Random rand = new Random();
    private Statistics stats;
    
    public Game() {
    	this(null);
    }
 
    public Game(Statistics stats){
    	if (stats != null)
    		this.stats = stats;
    	else
    		this.stats = new NullStatistics();
    	System.out.println("asdjasdjasdasd");
    }

    
    public void addPlayer(Player player) {
    	for (Player p : players) {
    		if (p.getName().equals(player.getName()))
    			throw new IllegalArgumentException("taki gracz juz istnieje");  			
    	}
        players.add(player);
    }
    public void printPlayers() {
    	for (Player p : players)
    		System.out.println(p.getName());
    }
    public void printStats() {
    	System.out.println("########");
    	stats.print();
    }
    
    public void removePlayer(String name) {
    	Iterator<Player> it = players.iterator();
    	while(it.hasNext()) {
    		String listName = it.next().getName();
    		if (listName.equals(name))
    			it.remove();
    	}
    }
    public String findUniqueName(String name) {
    	Iterator<Player> it = players.iterator();
    	while(it.hasNext()) {
    		String listName = it.next().getName();
    		if (listName.equals(name)) {
    			Random r = new Random();
    			return (name.concat((Integer.toString(r.nextInt(9)+1))));
    		}
    	}	
    	return name; 
    }
    public void play() {
    	
		if (players.isEmpty()) {
	    	throw new IllegalStateException("Brak graczy");
	    }
		
	    int number;   
        int guess;      

        boolean repeat;

        do {
            System.out.println("---------------------");

            repeat = true;

            number = rand.nextInt(6) + 1;
            System.out.println("Kostka: " + number);

            for (Player player : players) {
                guess = player.guess();
                System.out.println("Gracz " + player.getName() + ": " + guess);

                if (number != guess) {
                    System.out.println("PUD£O!");
                } else {
                    System.out.println("BRAWO!");
                    stats.updateScore(player);
                    repeat = false;
                }
            }
        } while (repeat);
    }
}