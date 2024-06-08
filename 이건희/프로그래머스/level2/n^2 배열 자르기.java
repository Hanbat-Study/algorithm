import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)(right- left + 1)];
        long now = left;
        
        for (int i = 0; i <= right - left; i++) {
            int x = (int)(now % n);
            int y = (int)(now / n);
            
            if (x <= y) result[i] = y + 1;
            else result[i] = x + 1;
            now++;    
        }
        
        return result;
    }
}
