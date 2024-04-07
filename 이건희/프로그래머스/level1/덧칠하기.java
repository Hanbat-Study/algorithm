class Solution {
    public int solution(int n, int m, int[] section) {
        int result = 0;
        int now = 0;
        
        for (int i = 0; i < section.length; i++) {
            if (now < section[i]) {
                now = section[i] + m -1;
                result++;
            } else continue;
        }
        
        return result;
    }
}
