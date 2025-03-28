import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int result = 0;
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < players.length; i++) {
            while (!q.isEmpty() && i == q.element()) {
                q.poll();
            }
            
            int cur = players[i];
            
            if (cur / m <= q.size()) continue;
            else {
                int n = cur / m - q.size();
                
                for (int j = 0; j < n; j++) {
                    q.add(i + k);
                    
                    result++;
                }
            }
        }
        
        return result;
    }
}
