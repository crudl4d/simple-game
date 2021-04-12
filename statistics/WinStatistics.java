package statistics;
import java.util.HashMap;

import players.Player;

public class WinStatistics implements Statistics {
	
	private HashMap<Player, Integer> stats = new HashMap<Player, Integer>();
	
	public void updateScore(Player player){
		int s = stats.getOrDefault(player, 0);
		s++;
		stats.put(player, s);
	}
	public void clear(){
		stats.clear();
	}
	public void print() {
		stats.forEach((player, score) ->
			System.out.println(player.getName() + ": " + score));
	}
}
