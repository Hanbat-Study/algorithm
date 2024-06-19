import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        int index = 0;
        
        for (char c = 'A'; c <= 'Z'; c++) {
            words.add(String.valueOf(c));
        }
        
        while (index < msg.length()) {
            String word = String.valueOf(msg.charAt(index));
            int lastMatchIndex = -1;
            
            while (index < msg.length() && words.contains(word)) {
                lastMatchIndex = words.indexOf(word);
                index++;
                if (index < msg.length()) {
                    word += msg.charAt(index);
                }
            }
            
            result.add(lastMatchIndex + 1);
            
            if (index < msg.length()) {
                words.add(word);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}
