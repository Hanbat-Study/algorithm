import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        System.out.println(photo.length);
        
        Map<String, Integer> scores = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            scores.put(name[i], yearning[i]);
        }
        
        System.out.println(Arrays.toString(answer));
        for(int i = 0; i < photo.length; i++) {
            int score = 0;
            for(String n : photo[i]) {
                if(scores.containsKey(n))
                    score += scores.get(n);
            }
            answer[i] = score;
        }
        
        return answer;
    }
}
