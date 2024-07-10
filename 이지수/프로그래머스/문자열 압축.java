class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        StringBuilder cur = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        for(int i = 1; i <= s.length() / 2; i++) {
            int idx = 0;
            pattern.setLength(0);
            int cnt = 0;
            StringBuilder str = new StringBuilder();
            while(idx < s.length() - s.length() % i) {
                cur.setLength(0);
                
                int j = 0;
                for(; j < i; j++)
                    cur.append(s.charAt(idx++));

                if(pattern.length() == 0) {
                    pattern.append(cur.toString());
                    str.append(pattern.toString());
                    cnt++;
                    continue;
                }
                    
                if(cur.toString().equals(pattern.toString()))
                    cnt++;
                else {
                    if(cnt > 1)
                        str.append(cnt + "");
                    cnt = 1;
                    pattern.setLength(0);
                    pattern.append(cur.toString());
                    str.append(cur.toString());
                }
            }
            
            if(cnt > 1)
                str.append(cnt + "");
            
            if(idx < s.length())
                str.append(s.substring(idx));
            
            answer = Math.min(answer, str.length());
        }
        
        return answer;
    }
}
