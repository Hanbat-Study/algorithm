import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        HashMap<String, Integer> count = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            count.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> cnt = new HashMap<>(count);
            int n = 10;
            
            for (int j = i; j < i + 10; j++) {
                if (!cnt.containsKey(discount[j])) break;
                
                int now = cnt.get(discount[j]);
                
                if (0 < now) {
                    cnt.replace(discount[j], now - 1);
                    n--;
                    
                    if (n == 0) result++;
                }
                else break;
            }

        }
        
        return result;
    }
}
