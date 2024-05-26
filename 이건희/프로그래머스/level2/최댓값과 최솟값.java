class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        int minNum = Integer.parseInt(nums[0]);
        int maxNum = Integer.parseInt(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int now = Integer.parseInt(nums[i]);
            
            if (now < minNum) minNum = now;
            else if (maxNum < now) maxNum = now;
        }
        
        return minNum + " " + maxNum;
    }
}
