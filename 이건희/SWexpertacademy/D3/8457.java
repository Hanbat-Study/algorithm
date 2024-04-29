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
            int B = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int result = 0;
            st = new StringTokenizer(br.readLine());
 
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
 
                for (int j = B - E; j <= B + E; j++) {
                    if (j % num == 0) {
                        result++;
                        break;
                    }
                }
            }
 
            System.out.printf("#%d %d\n", test_case, result);
 
 
        }
    }
}
