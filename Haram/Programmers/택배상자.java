import java.util.Stack;

public class Solution {
	public int solution(int[] order) {
		int idx = 0;
	
		Stack<Integer> s = new Stack<>();
		for(int curBox = 1; curBox < order.length+1; curBox++) {
			if(curBox == order[idx]) {
				idx++;
			} 
			else if(!s.isEmpty() && s.peek() == order[idx]) {
				idx++;
				curBox--;
				s.pop();
			}
			else {
				s.add(curBox);
			}
		}
		
		while(!s.isEmpty()) {
			int ele = s.pop();
			if(ele == order[idx]) idx++;
			else break;
		}
		
        return idx;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {4, 3, 1, 2, 5}));
		System.out.println(s.solution(new int[] {5, 4, 3, 2, 1}));
		
		// 반례
		System.out.println(s.solution(new int[] {3, 2, 1, 4, 5}));
	}

}
