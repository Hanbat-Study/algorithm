import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int[] eles = new int[elements.length * 2];
        HashSet<Integer> set = new HashSet<>();
        
        for(int j = 0; j < elements.length * 2; j++) {
            eles[j] = elements[j % elements.length];
        }
        
        for(int r = 1; r < elements.length+1; r++) {
            for(int i = 0; i < elements.length; i++) {            
                int temp = 0;
                for(int j = i; j < i + r; j++) {
                    temp = temp + eles[j];
                }
                set.add(temp);
            }
        }
        
        return set.size();
    }
}
