class Solution {
    public String solution(int n) {
        return (n % 2 == 0) ? "수박".repeat(n / 2) : "수박".repeat(n / 2 + 1).substring(0, n); 
    }
}
