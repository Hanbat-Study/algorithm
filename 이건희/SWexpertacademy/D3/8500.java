import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = 0;
            int maxNum = 0;
 
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
 
                maxNum = Math.max(maxNum, num);
                result += num;
            }
 
            result += maxNum + N;
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
