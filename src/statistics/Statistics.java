package statistics;

import players.Player;

public interface Statistics {
	void updateScore(Player player);
	void clear();
	void print();
}
