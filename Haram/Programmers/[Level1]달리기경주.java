import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> orders = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            orders.put(players[i], i);
        }
        
        for(String calling : callings) {
            int idx = orders.get(calling);
            if(idx <= 0) continue;
            String temp = players[idx];
            players[idx] = players[idx-1];
            players[idx-1] = temp;
            
            orders.put(players[idx], idx);
            orders.put(players[idx-1], idx-1);
        }
        
        return players;
    }
}
