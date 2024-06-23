import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        
        for (int i = 0; i < topping.length; i++) {
            set.add(topping[i]);
            
            if (map.get(topping[i]) == 1) map.remove(topping[i]);
            else map.put(topping[i], map.get(topping[i]) - 1);
            
            if (map.size() == set.size()) result++;
        }
            
        return result;
    }
}
