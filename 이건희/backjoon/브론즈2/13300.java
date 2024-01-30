import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;
        int[][] arr = new int[6][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken()) - 1;

            arr[Y][S] += 1;
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                if (arr[i][j] % K == 0) {
                    result += arr[i][j] / K;
                } else result += arr[i][j] / K + 1;
            }
        }
        System.out.println(result);
    }
}
