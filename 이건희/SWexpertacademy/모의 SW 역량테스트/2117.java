import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, M, result;
    static int[] nums;
    static int[][] arr;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = 23;
            arr = new int[N][N];
            nums = new int[K + 1];
            result = 0;
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                 
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int i = 1; i <= K; i++) {
                nums[i] = i * i + (i - 1) * (i - 1);
            }
             
            for (int i = 1; i <= K; i++) {
                for (int j = 0; j < N; j++) {
                    for (int l = 0; l < N; l++) {
                        check(i, j, l);
                    }
                }
            }
             
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
     
    public static void check(int n, int y, int x) {
        int cnt = 0;
         
        for (int i = -(n - 1); i <= n - 1; i++) {
            for (int j = x - (n - 1 - Math.abs(i)); j <= x + (n - 1 - Math.abs(i)); j++) {
                if (0 <= y + i && y + i < N && 0 <= j && j < N && arr[y + i][j] == 1) cnt++;
            }
        }
         
        if (0 <= cnt * M - nums[n]) result = Math.max(result, cnt);
    }
}
