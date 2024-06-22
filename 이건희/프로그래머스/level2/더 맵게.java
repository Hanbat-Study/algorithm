import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int result = 0;
        PriorityQueue<Integer> s = new PriorityQueue<>();
        
        for (int sc : scoville) {
            s.add(sc);
        }
        
        while (s.size() > 1 && s.peek() < K) {
            int firstMin = s.poll();
            int secondMin = s.poll();
            int newScoville = firstMin + (secondMin * 2);
            s.add(newScoville);
            result++;
        }
        
        if (s.peek() < K) {
            return -1;
        }
        
        return result;
    }
}
