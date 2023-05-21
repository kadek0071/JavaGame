package pio_game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Game {

    private List<Player> players = new ArrayList<>();
    private Statistics statistics = new NullStatistics();

    private Random rand = new Random();     //obiekt losujący
    
    public Game(){}    
    
    public Game(WinStatistics statistics) {
        if(statistics != null){
            this.statistics = statistics;            
        }
    }

    public void addPlayer(Player player){
        if(!nameExists(player.getName())){
            players.add(player);
        }else{
             player.setName(player.getName() + rand.nextInt(10));
            addPlayer(player);
        }
    }

    private boolean nameExists(String name){
        for(Player player : players){
            if(player.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    public void printPlayers(){
        players.forEach(player -> {
           System.out.println(player.toString()); 
        });
    }
    ///////
    public void removePlayer(String name){
        players.removeIf(player -> player.getName().equals(name));
    }
    
    /*public void removePlayer(String name){
        for(int i=0; i<players.size(); ++i){
            Player player = players.get(i);
            if(player.getName().equals(name)){
                players.remove(i);
                break;
            }
        }        
    }*/    
    /*
    public void removePlayer(String name){
        for(Iterator<Player> it = players.iterator(); it.hasNext();){
            if(it.next().getName().equals(name)){
                it.remove();
                break;
            }
        }
    }
*/
    public void printStatistics(){
        statistics.print();
    }
    
    public void clearStatistics(){
        statistics.clear();
    }

    public void play(){

        Random dice = new Random();

        int number;
        int guess;
        boolean repeat;

        do{      
            number = dice.nextInt(6)+1;
            System.out.println("Wylosowano: "+number);

            repeat = true;

            for(Player player : players){
                guess = player.guess();
                System.out.println(player.getName()+": "+guess);

                if (number != guess) {
                    System.out.println("PUDŁO! "+guess);
                    repeat = false;
                }
                else {
                    System.out.println("BRAWO! "+guess);
                    statistics.winner(player);
                }
            }
            System.out.println();
        }while(repeat);

    }
    
}
