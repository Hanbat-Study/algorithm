import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
 
class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= t; test_case++) {
            String s = br.readLine();
            ArrayDeque<Character> stack = new ArrayDeque<>();
            int result = 0;
            char pre = ' ';
             
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);             
                if (now == '(') {
                    stack.addLast(now);
                } else {
                    if (pre == '(') {
                        stack.removeLast();
                        result += stack.size();
                    } else {
                        stack.removeLast();
                        result++;
                    }
                }
                pre = now;
            }
             
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
