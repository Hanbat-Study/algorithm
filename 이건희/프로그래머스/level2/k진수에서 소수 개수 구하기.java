import java.util.*;

class Solution {
    static int result;
    
    public int solution(int n, int k) {
        result = 0;
        String[] nums = change(n, k).split("0");
        
        for (String num : nums) {
            if (num.isEmpty()) continue;
            
            Long now = Long.parseLong(num);
            
            prime(now);
        }
        
        return result;
    }
    
    public static String change(int number, int base) {
        StringBuilder num = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            num.insert(0, remainder);
            number /= base;
        }
        return num.toString();
    }
    
    public void prime(long num) {
        if (num < 2) {
            return;
        } else if (num == 2) {
            result++;
            return;
        }

        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return;
            }
        }

        result++;
    }
}
