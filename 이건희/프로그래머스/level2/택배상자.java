import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            if (order[result] != i) {
                stack.add(i);
            } else {
                result++;
                
                while (!stack.isEmpty()) {
                    if (stack.peek() == order[result]) {
                        stack.pop();
                        result++;
                    } else break;
                }
            }
        }
        
        return result;
    }
}
