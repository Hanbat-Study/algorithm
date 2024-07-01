class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int t = n % 3;
            
            if (t == 0) {
                t = 4;
                n -= 1;
            }
            
            sb.append(t);
            n /= 3;
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}
