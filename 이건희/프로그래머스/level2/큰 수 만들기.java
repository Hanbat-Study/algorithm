import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < number.length(); i++) {
            while (!stack.empty() && stack.peek() < number.charAt(i) - '0' && 0 < k) {
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i) - '0');
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        for (int num : stack) {
            result.append(num);
        }

        return result.toString();
    }
}
