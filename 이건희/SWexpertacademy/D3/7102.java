import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
 
            StringBuilder sb = new StringBuilder();
 
            for (int i = Math.min(N, M) + 1; i <= Math.max(N, M) + 1; i++) {
                sb.append(i).append(" ");
            }
 
            System.out.printf("#%d %s\n", test_case, sb);
        }
    }
}
