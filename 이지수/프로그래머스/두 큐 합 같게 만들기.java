import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        int length = queue1.length;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
            
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        int cnt = 0;
        while(cnt <= length * 2 + 1) {
            if(sum1 == sum2)
                break;
            
            if(sum2 < sum1) {
                int n = q1.poll(); 
                q2.offer(n);
                sum1 -= n;
                sum2 += n;
            } else {
                int n = q2.poll(); 
                q1.offer(n);
                sum2 -= n;
                sum1 += n;
            }
            
            cnt++;
        }
        
        if(sum1 != sum2)
            return -1;
        
        return cnt;
    }
}
