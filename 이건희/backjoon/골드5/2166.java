import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double result;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = r;
            arr[i][1] = c;
        }

        for (int i = 0; i < N; i++) {
            result += (double) arr[i][0] * arr[(i + 1) % N][1];
            result -= (double)arr[i][1] * arr[(i + 1) % N][0];
        }

        System.out.printf("%.1f", Math.abs(result / 2));
    }
}
