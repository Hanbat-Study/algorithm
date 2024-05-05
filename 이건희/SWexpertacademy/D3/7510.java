import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int result = 0;
 
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
 
                for (int j = i; j <= N; j++) {
                    cnt += j;
 
                    if (cnt == N) result++;
                    else if (N < cnt) break;
                }
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
 
    }
}
