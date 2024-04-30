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
            int K = Integer.parseInt(st.nextToken());
 
            StringBuilder sb = new StringBuilder();
            int[] arr = new int[K];
            int idx = 0;
            int cnt = 1;
 
            while (cnt <= N * K) {
                if (idx % 2 == 0) {
                    for (int i = 0; i < K; i++) {
                        arr[i] += cnt;
                        cnt++;
                    }
                } else {
                    for (int i = K - 1; 0 <= i; i--) {
                        arr[i] += cnt;
                        cnt++;
                    }
                }
                idx++;
            }
 
            for (int i = 0; i < K; i++) {
                sb.append(arr[i]).append(" ");
            }
 
            System.out.printf("#%d %s\n", test_case, sb);
        }
    }
}
