class Solution {
    public int solution(int n) {
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for (int j = i; j < n + 1; j++) {
                cnt += j;
                if (cnt == n) {
                    result++;
                    break;
                } else if (cnt > n) {
                    break;
                }
            }
        }
        return result;
    }
}
