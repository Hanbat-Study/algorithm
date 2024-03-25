import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
        }
        
        for(int i = 0; i < queue2.length; i++) {
            q2.offer(queue2[i]);
        }
        
        long sum1 = sum(q1);
        long sum2 = sum(q2);
        long target = (sum1 + sum2) / 2;
        int size = q1.size() * 3;
         
        for(int i = 0; i < size; i++) {
            if(sum1 < sum2) {
                long ele = q2.poll();
                q1.offer((int)ele);
                sum1 += ele;
                sum2 -= ele;
                answer++;
            } 
            else if (sum1 > sum2) {
                long ele = q1.poll();
                q2.offer((int)ele);
                sum1 -= ele;
                sum2 += ele;
                answer++;
            }
            else return answer;
        }
        
        return -1;
    }
    
    public long sum(Queue<Integer> q) {
        long sum = 0;
        for(int ele : q) sum += ele;
        return sum;
    }
}
