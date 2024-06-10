import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int result = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        for (int count : map.values()) {
            result *= (count + 1);
        }
        
        return result - 1;
    }
}
