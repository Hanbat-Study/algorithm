class Solution {
    public long solution(int n) {
        long result = 0;
        long a = 0;
        long b = 1;
        
        for (int i = 1; i <= n; i++) {
            long temp = b;
            b += a;
            a = temp;
            b %= 1234567;
        }
        
        return b;
    }
}
