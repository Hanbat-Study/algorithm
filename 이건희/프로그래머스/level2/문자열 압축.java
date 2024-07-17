import java.util.*;

class Solution {
    public int solution(String s) {
        int result = s.length();
        
        if (s.length() == 1) return 1;
        
        for (int i = 1; i <= s.length() / 2; i++) {
            List<String> words = splitString(s, i);
            int cnt = 1;
            int len = 0;
            
            for (int j = 0; j < words.size() - 1; j++) {
                if (j == words.size() - 2) {
                    if (words.get(j).equals(words.get(j + 1))) {
                        cnt++;
                        len += i + String.valueOf(cnt).length();
                    }
                    else {
                        if (cnt == 1) {
                            len += i;
                        } else {
                            len += i + String.valueOf(cnt).length();
                            cnt = 1;
                        }
                        
                        len += words.get(j + 1).length();
                    }
                } else {
                    if (words.get(j).equals(words.get(j + 1))) {
                        cnt++;
                    } else {
                        if (cnt == 1) {
                            len += i;
                        } else {
                            len += i + String.valueOf(cnt).length();
                            cnt = 1;
                        }
                    }
                }
            }
            
            result = Math.min(result, len);
        }
        
        return result;
    }
    
    private List<String> splitString(String s, int n) {
        List<String> words = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i += n) {
            if (i + n < s.length()) {
                words.add(s.substring(i, i + n));
            } else {
                words.add(s.substring(i));
            }
        }
        
        return words;
    }
}
