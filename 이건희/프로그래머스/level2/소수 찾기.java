import java.util.*;

class Solution {
    static HashSet<Integer> result;
    static ArrayList<Integer> numList;

    public int solution(String numbers) {
        result = new HashSet<>();
        numList = new ArrayList<>();
        char[] nums = new char[numbers.length()];
        
        for (int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i);
        }
        
        generatePermutations(nums, 0, new boolean[numbers.length()], new StringBuilder());
        
        Collections.sort(numList);
        int index = 0;
        
        for (int num : numList) {
            check(num);
        }
        
        return result.size();
    }
    
    private void generatePermutations(char[] nums, int depth, boolean[] used, StringBuilder current) {
        if (depth == nums.length) {
            if (current.length() > 0) {
                numList.add(Integer.parseInt(current.toString()));
            }
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            current.append(nums[i]);
            generatePermutations(nums, depth + 1, used, current);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
        
        if (current.length() > 0 && 2 <= Integer.parseInt(current.toString())) {
            numList.add(Integer.parseInt(current.toString()));
        }
    }
    
    public void check(int num) {
        for (int i = 2; i < (int)(Math.sqrt(num) + 1); i++) {
            if (num % i == 0) return;
        }
        
        result.add(num);
        return;
    }
}
