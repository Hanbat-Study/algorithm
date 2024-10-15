import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> numbers = new HashSet<>();
        
        for(int num: nums){
            numbers.add(num);
        }
        
        answer=Math.min(nums.length/2, numbers.size());
        
        return answer;
    }  
}
