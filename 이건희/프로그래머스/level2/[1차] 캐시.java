import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int result = 0;
        LinkedList<String> queue = new LinkedList<>();
        
        if (cacheSize == 0) return cities.length * 5;
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (queue.contains(city)) {
                result++;
                queue.remove(city);
                queue.offer(city);
            } else {
                result += 5;
                
                if (queue.size() < cacheSize) queue.offer(city);
                else {
                    queue.poll();
                    queue.offer(city);
                }
            }
        }
        
        return result;
    }
}
