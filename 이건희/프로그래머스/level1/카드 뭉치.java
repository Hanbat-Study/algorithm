import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String result = "Yes";
        int num1 = 0;
        int num2 = 0;
        
        for (String word : goal) {
            if (num1 < cards1.length&& word.equals(cards1[num1])) {
                num1++;
            } else if (num2 < cards2.length && word.equals(cards2[num2])) {
                num2++;
            } else {
                result = "No";
                break;
            }
        }
        return result;
    }
}
