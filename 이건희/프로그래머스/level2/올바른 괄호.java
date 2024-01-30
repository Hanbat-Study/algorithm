class Solution {
    boolean solution(String s) {
        boolean result = true;
        int cnt = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ('(')) {
                cnt ++;
            } else cnt --;
            
            if (cnt < 0) {
                break;
            }
        }
        if (cnt != 0) {
            result = false;
        }

        return result;
    }
}
