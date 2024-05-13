import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int score, num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            score = 0;
            num = 0;
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int cnt = 0;
 
                for (int j = 0; j < M; j++) {
                    if (st.nextToken().equals("1")) cnt++;
                }
 
                if (cnt == score) num++;
                else if (score < cnt) {
                    score = cnt;
                    num = 1;
                }
            }
 
            System.out.printf("#%d %d %d\n", test_case, num, score);
        }
    }
}
