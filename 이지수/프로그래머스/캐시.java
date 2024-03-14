import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();

            if(cache.contains(city)) {
                cache.remove(cache.indexOf(city));
                cache.add(city);
                answer += 1;
                continue;
            }
            
            answer += 5; 
            cache.add(city);
            if(isFull(cache, cacheSize + 1)) {
                cache.remove(0);   
            }
        }
        
        return answer;
    }
    
    private boolean isFull(ArrayList cache, int size) {
        if(cache.size() >= size)
            return true;
        
        return false;
    }
}
