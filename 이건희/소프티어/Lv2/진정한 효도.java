import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.MAX_VALUE;
        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cnt = 0;

                for (int k = 0; k < 3; k++) {
                    cnt += Math.abs(arr[i][j] - arr[i][k]);
                }

                result = Math.min(result, cnt);
                cnt = 0;

                for (int k = 0; k < 3; k++) {
                    cnt += Math.abs(arr[j][i] - arr[k][i]);
                }

                result = Math.min(result, cnt);
            }
        }

        System.out.println(result);
    }
}
