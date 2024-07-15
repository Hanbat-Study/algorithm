import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int result = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < enemy.length; i++) {
            heap.add(enemy[i]);
            
            if (heap.size() <= k) {
                result++;
                continue;
            }
            
            n-= heap.poll();
                
            if (n < 0) break;
            
            result++;
        }

        return result;
    }
}
