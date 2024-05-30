import java.util.*;

public class Solution {
    public int solution(int n) {
        int result = 0;
        
        while (0 < n) {
            if (n % 2 == 0) n /= 2;
            else {
                n -= 1;
                result++;
            }
        }

        return result;
    }
}
