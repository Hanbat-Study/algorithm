import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            int K = Integer.parseInt(br.readLine());
 
            Stack<Integer> nums = new Stack<>();
            int result =0;
 
            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine());
 
                if (num == 0) nums.pop();
                else nums.add(num);
            }
 
            for (Integer num : nums) {
                result += num;
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
