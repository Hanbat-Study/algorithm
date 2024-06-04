import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int result = 0;
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            count.put(tangerine[i], count.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> keys = new ArrayList<>(count.keySet());
        keys.sort((a, b) -> count.get(b) - count.get(a));
        
        for (int i = 0; i < keys.size(); i++) {
            k -= count.get(keys.get(i));
            result++;
            
            if (k <= 0) return result;
        }
        
        return result;
    }
}
