import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        String[] words = s.split("");
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (stack.isEmpty()) {
                stack.push(word);
            } else {
                if (stack.peek().equals(word)) {
                    stack.pop();
                } else stack.push(word);
            }
        }
        
        if (stack.isEmpty()) return 1;
        return 0;
    }
}
