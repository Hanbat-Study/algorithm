import java.util.*;

class Solution {
    static HashMap<String,Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();
        
        for (int c : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                if (order.length() < c) continue;
                
                char[] orderArr = order.toCharArray();
                Arrays.sort(orderArr);
                order = new String(orderArr);
                
                cal(order, c, "", 0);
            }
            
            ArrayList<String> words = new ArrayList<>();
            int cnt = 2;
            
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
            
                if (cnt < value) {
                    cnt = value;
                    words = new ArrayList<>();
                    words.add(key);
                } else if (cnt == value) {
                    words.add(key);
                }
            }
            
            for (String word : words) {
                result.add(word);
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    
    private void cal(String order, int c, String word, int start) {
        if (c == 0) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            } return;
        }
        
        for (int i = start; i < order.length(); i++) {
            cal(order, c - 1, word + order.charAt(i), i + 1);
        }
    }
}
