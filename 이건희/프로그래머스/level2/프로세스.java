import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int result = 1;
        int num = priorities[location];
        Queue<Integer> q = new LinkedList<>();
        
        for (int p : priorities) {
            q.add(p);
        }
        
        while (true) {
            int first = q.peek();
            int maxNum = 0;
            
            for (int n : q) {
                if (maxNum < n) maxNum = n;
            }
            
            if (first == maxNum) {
                if (location == 0) break;
                else {
                    q.poll();
                    location -= 1;
                    result++;
                }
            }
            else {
                if (location == 0) {
                    q.offer(q.poll());
                    location = q.size() - 1;
                }
                else {
                    q.offer(q.poll());
                    location -= 1;
                }
            }
        }
        
        return result;
    }
}
