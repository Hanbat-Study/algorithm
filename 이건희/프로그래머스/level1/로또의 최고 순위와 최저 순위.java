import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int max = 0;
        int min = 0;
        int[] result = new int[2];
        
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                max++;
                continue;
            }
            
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    max++;
                    min++;
                    break;
                }
            }
        }
        result[0] = getGrade(max);
        result[1] = getGrade(min);
        return result;
    }
    
    public int getGrade(int n) {
        switch(n) {
            case 6 :
                return 1;
            case 5 :
                return 2;
            case 4 :
                return 3;
            case 3 :
                return 4;
            case 2 :
                return 5;
            default :
                return 6;
        }
    }
}
