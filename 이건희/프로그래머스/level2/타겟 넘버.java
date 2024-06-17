import java.util.*;

class Solution {
    static int result;
    static int lenNum;
    
    public int solution(int[] numbers, int target) {
        result = 0;
        lenNum = numbers.length;
        
        cal(numbers, target, 0, 0);
        
        return result;
    }
    
    public void cal(int[] numbers, int target, int cnt, int sum) {
        if (cnt == lenNum) {
            if (sum == target) result++;
            return;
        }
        
        cal(numbers, target, cnt + 1, sum + numbers[cnt]);
        cal(numbers, target, cnt + 1, sum - numbers[cnt]);
    }
}
