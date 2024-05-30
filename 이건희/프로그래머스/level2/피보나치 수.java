class Solution {
    public int solution(int n) {
        int temp = 0;
        int a = 1;
        int b = 1;

        if (n == 2) return b;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp % 1234567;
        }
        return b % 1234567;
    }
}
