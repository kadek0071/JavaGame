
package pio_game;

public class Pio_Game {
    
    public static void main(String[] args) {
        
        Game game = new Game(/*new NullStatistics()*/new WinStatistics()/*null*/);
        
        game.addPlayer(new PlayerComp("Janusz"));
        game.addPlayer(new PlayerComp("Janusz2"));
        
        game.printPlayers();

        //game.play();
        
        for(int i=0; i<10; ++i){
            game.play();
        }
        
        game.printStatistics();        
        game.removePlayer("Janusz");
        game.clearStatistics();
        game.printStatistics();
        
    }
    
}
