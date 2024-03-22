import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] result = new int[score.length];
        int[] reward = {-1}; * k;
        
        for (int i = 0; i < score.length; i++) {
            if (score[i] > reward[0])
                reward[0] = score[i];
            
            Arrays.sort(reward);
            System.out.println(Arrays.toString(reward));
            for (int j = 0; j < k; j++) {
                if (reward[j] < 0) {
                    continue;
                } else result[i] = reward[j];
            }
        }
        return result;
    }
}
