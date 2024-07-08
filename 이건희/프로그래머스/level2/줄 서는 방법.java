import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] result = new int[n];
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        n--;
        k--;
        int cnt = n;
        
        for (int i = 0; i <= cnt; i++) {
            long f = factorial(n);
            int num = (int)(k / f);
            
            result[i] = list.get(num);
            list.remove(num);
            
            k = k % f;
            n--;
        }
        
        return result;
    }
    
    public long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
