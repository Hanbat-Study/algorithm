import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] doubledElements = new int[elements.length * 2];

        System.arraycopy(elements, 0, doubledElements, 0, elements.length);
        System.arraycopy(elements, 0, doubledElements, elements.length, elements.length);
        
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int sum = 0;
                for (int k = j; k < j + i; k++) {
                    sum += doubledElements[k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
