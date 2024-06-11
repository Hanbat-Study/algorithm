import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) days[i] = (100 - progresses[i]) / speeds[i];
            else days[i] = (100 - progresses[i]) / speeds[i] + 1;
        }
        
        int now = days[0];
        int cnt = 1;
        
        for (int i = 1; i < days.length; i++) {
            if (now < days[i]) {
                now = days[i];
                result.add(cnt);
                cnt = 1;
            } else cnt++;
        }
        
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
