package players;
public class Main {

	public static void main(String[] args) {
	
		Game game = new Game();
        
        game.addPlayer(new PlayerComp("Piotr"));
        game.addPlayer(new PlayerComp("Pawel"));
        game.addPlayer(new PlayerComp("trzeci"));

        try {
        	for(int i=0; i<100; i++) {
        		game.play();
        	}
        	} catch(IllegalStateException e) {
        	System.out.println(e.getMessage());
        }
        game.printStats();
    } 
}