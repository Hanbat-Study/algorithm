class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        int cnt = 0;
        
        while (n >= a) {
            cnt = n / a;
            result += cnt * b;
            n = b * (n / a) + n % a;
        }
        
        return result;
    }
}
