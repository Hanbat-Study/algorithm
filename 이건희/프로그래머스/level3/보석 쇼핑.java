import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems));
        int lenGem = uniqueGems.size();
        
        Map<String, Integer> gemCount = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[]{1, gems.length};

        while (right < gems.length) {
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            right++;

            while (gemCount.size() == lenGem) {
                if (right - left < minLength) {
                    minLength = right - left;
                    result[0] = left + 1;
                    result[1] = right;
                }
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]);
                }
                left++;
            }
        }
        
        return result;
    }
}
