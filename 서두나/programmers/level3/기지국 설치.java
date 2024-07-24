import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int coverage = 2 * w + 1; 
        int start = 1;  
        
        for (int station : stations) {
            int leftCoverageStart = station - w; 
            if (start < leftCoverageStart) {
                int gap = leftCoverageStart - start;
                answer += (gap + coverage - 1) / coverage; 
            }
            start = station + w + 1; 
        }
        
        if (start <= n) {
            int gap = n - start + 1;
            answer += (gap + coverage - 1) / coverage;
        }
        
        return answer;
    }
}
