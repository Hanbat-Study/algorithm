import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            double maxSlope = -Double.MAX_VALUE;

            for (int j = i + 1; j < N; j++) {
                double slope = (double) (arr[j] - arr[i]) / (j - i);

                if (maxSlope < slope) {
                    maxSlope = slope;

                    cnt++;
                }
            }

            maxSlope = -Double.MAX_VALUE;

            for (int j = i - 1; 0 <= j; j--) {
                double slope = (double) (arr[j] - arr[i]) / (i - j);

                if (maxSlope < slope) {
                    maxSlope = slope;

                    cnt++;
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }
}
