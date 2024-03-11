import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        int cur = 0;
        for(int i = 1; i <= order.length; i++) {
            if(!stack.isEmpty() && stack.peek() == order[cur]) {
                stack.pop();
                answer++;
                cur++;
                i--;
                continue;
            }
            
            if(order[cur] == i) {
                answer++;
                cur++;
                continue;
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int box = stack.pop();
            if(box == order[cur]) {
                answer++;
                cur++;
            }
            else
                break;
        }
        
        return answer;
    }
}
