import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int answer=0;
        int k=1;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        
        for(int i=0;i<order.length;i++){
            if(order[i]>=k){
                while (k<order[i]){
                    stack.add(k++);
                }
                k++;
            }
            else {
                if(stack.peek()!=order[i]){
                    break;
                }
                stack.pop();
            }
            answer++;
        }
        
        
        return answer;
    }
}
