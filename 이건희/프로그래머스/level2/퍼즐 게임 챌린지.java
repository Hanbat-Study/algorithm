import java.util.*;
import java.io.*;

class Solution {
    static int result;
    
    public int solution(int[] diffs, int[] times, long limit) {
        result = 0;
        int min = 1;
        int max = 300000;
        
        while (min < max) {
            result = (min + max) / 2;
            
            if (isCheck(diffs, times, limit)) max = result;
            else min = result + 1;
        }
        
        return max;
    }
    
    public static boolean isCheck(int[] diffs, int[] times, long limit) {
        long sum = 0;
        
        for (int i = 0; i < times.length; i++) {
            if (diffs[i] <= result) sum += times[i];
            else sum += (diffs[i] - result) * (times[i] + times[i - 1]) + times[i];
                
            if (limit < sum) return false;
        }
        
        return true;
    }
}
