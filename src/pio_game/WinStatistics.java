package pio_game;


import java.util.HashMap;
import java.util.Map;

public class WinStatistics implements Statistics {
    
    public WinStatistics(){}    
    private Map<String, Integer> stats = new HashMap<>();

    public void print() {
        //System.out.println(stats);
        if(stats.size()>0){
        System.out.println("--- STATS ---");
        stats.forEach((name,score) -> {
            System.out.println(name+": "+score);
        });
        }
    }   
    
    
    public void winner(Player player){
        Integer s = stats.getOrDefault(player.getName(), 0);
        s += 1;        
        stats.put(player.getName(), s);
    }
    
    public void clear(){
        stats.clear();        
    }
    
}
