import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution8104 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<= T; t++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] sum = new int[k];
//            int cnt = 1 + n * k;
//            if (n % 2 == 0) {
//                for (int i = 0; i < k; i++) {
//                    sb.append(cnt*(n/2)).append(" ");
//                }
//            }
//            else {
//                for (int i = 1; i<=k; i++) {
//                    cnt = 1+(n+2) * k;
//                    sb.append(cnt*(n/2) + i).append(" ");
//                }
//            }
            int cnt = 1;
            while (cnt <= n * k) {
                for (int i = 0; i < n; i++) {
                    if (i % 2 == 0) {
                        for (int j = 0; j < k; j++) {
                            sum[j] += cnt++;
                        }
                    } else {
                        for (int j = k - 1; j >= 0; j--) {
                            sum[j] += cnt++;
                        }
                    }
                }
            }
            for (int i = 0; i< k; i++) {
                sb.append(sum[i] + " ");
            }
            System.out.println("#"+ t + " "+ sb.toString().trim());
        }
    }
}