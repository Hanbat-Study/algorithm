import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0);
        
        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                int idx = stack.pop();
                
                if (numbers[idx] < numbers[i]) {
                    result[idx] = numbers[i];
                } else {
                    stack.push(idx);
                    break;
                }
            }
            
            stack.push(i);
        }
        
        return result;
    }
}
