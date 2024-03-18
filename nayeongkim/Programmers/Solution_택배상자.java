import java.util.*;
import java.io.*;

class Solution_택배상자 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>(); // 보조
        int next = 1;
        int answer = 0;

        for (int cur : order) {

            while (next <= cur) {
                stack.push(next);
                next++;
            }

            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                answer++;
            } else {

                break;
            }
        }

        return answer;
    }
}
