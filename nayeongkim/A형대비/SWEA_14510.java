import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class SWEA_14510 {
    static int[] trees, remains;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            trees = new int[n];
            remains = new int[n];
            int max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, trees[i]);
            }
            int odd = 0;
            int even = 0;
            for (int i = 0; i < n; i++) {
                remains[i] = max - trees[i];
                odd += remains[i] % 2;
                even += remains[i] / 2;
            }
            int result = odd + even;
            if (odd < even) {
                int gap = (even - odd) * 2;
                int remain = (gap/3) *2;
                if (gap % 3 == 2) {
                    remain += 2;
                }
                else if (gap% 3 == 1){
                    remain += 1;
                }
                result = (odd * 2) + remain;
            }
            else if (odd - even > 1) {
                result += (odd - even - 1);
            }
            System.out.println("#" + t + " " + result);

        }
    }

}