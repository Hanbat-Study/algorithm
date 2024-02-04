import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];
        int[][] nums = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int lx = Integer.parseInt(st.nextToken());

            nums[i] = new int[]{y, x, ly, lx};

            for (int j = y; j < y + ly; j++) {
                for (int k = x; k < x + lx; k++) {
                    arr[j][k] = i;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int y = nums[i][0];
            int x = nums[i][1];
            int ly = nums[i][2];
            int lx = nums[i][3];
            int cnt = 0;

            for (int j = y; j < y + ly; j++) {
                for (int k = x; k < x + lx; k++) {
                    if (arr[j][k] == i) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
