import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] result = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = i;
                int y = yellow / i;
                
                if ((x + y) * 2 + 4 == brown) {
                    result[0] = Math.max(x, y) + 2;
                    result[1] = Math.min(x, y) + 2;
                    break;
                }
            }
        }
        return result;
    }
}
