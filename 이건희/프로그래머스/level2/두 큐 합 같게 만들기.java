import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int cnt = 0;
        int result = 0;
        int l = (queue1.length + queue2.length) * 2;
        for (int q : queue1) {
            sum1 += q;
            q1.offer(q);
        }
        
        for (int q : queue2) {
            sum2 += q;
            q2.offer(q);
        }
        
        while (cnt < l) {
            cnt++;
            
            if (sum1 < sum2) {
                int num = q2.poll();
                q1.offer(num);
                sum1 += num;
                sum2 -= num;
                result++;
            } else if (sum2 < sum1) {
                int num = q1.poll();
                q2.offer(num);
                sum2 += num;
                sum1 -= num;
                result++;
            } else return result;
        }
        return -1;
    }
}
