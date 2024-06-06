class Solution {
    public int solution(String s) {
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            String words = s;
            
            while (true) {
                int len = words.length();
                words = words.replace("()", "");
                words = words.replace("{}", "");
                words = words.replace("[]", "");
                
                if (len == words.length()) break;
            }
            
            if (words.length() == 0) result++;
        }
        return result;
    }
}
