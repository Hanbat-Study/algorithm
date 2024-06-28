import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int idx = 0;
        int bridgeWeight = 0;
        Queue<int[]> queue = new LinkedList<>(); 

        while (true) {
            answer++;

            if (!queue.isEmpty() && queue.peek()[1] == 0) {
                bridgeWeight -= queue.poll()[0];
            }

            if (idx < truck_weights.length && bridgeWeight + truck_weights[idx] <= weight) {
                bridgeWeight += truck_weights[idx];
                queue.offer(new int[]{truck_weights[idx], bridge_length});
                idx++;
            }

            for (int[] truck : queue) {
                truck[1]--;
            }

            if (idx == truck_weights.length && queue.isEmpty()) {
                break;
            }
        }

        return answer;
    }
}
