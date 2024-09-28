import java.util.*;

class Solution {
    static boolean[] visited;
    static int result;
    
    public int solution(String begin, String target, String[] words) {
        result = Integer.MAX_VALUE;
        visited = new boolean[words.length];
        
        if (!Arrays.asList(words).contains(target)) return 0;

        check(words, begin, target, 0);
        
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }
    
    public void check(String[] words, String begin, String target, int cnt) {
        if (begin.equals(target)) {
            result = Math.min(result, cnt);
            return;
        } else if (cnt == words.length) return;
        
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;
            
            if (canChange(begin, words[i])) {
                visited[i] = true;
                check(words, words[i], target, cnt + 1);
                visited[i] = false;
            }
        }
    }
    
     private boolean canChange(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
