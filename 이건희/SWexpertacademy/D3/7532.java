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
 
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int result = 0;
            int s = 0;
            int e = 0;
            int m = 0;
 
            while (true) {
                result++;
                s++;
                e++;
                m++;
 
                if (365 < s) s = 1;
                if (24 < e) e = 1;
                if (29 < m) m = 1;
 
                if (s == S && e == E && m == M) break;
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
