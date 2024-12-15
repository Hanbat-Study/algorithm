import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static int[] arr, dp1, dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp1 = new int[n];
        dp2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp1[0] = arr[0];
        result = dp1[0];

        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
            result = Math.max(result, dp1[i]);
        }

        dp2[n - 1] = arr[n - 1];

        for (int i = n - 2; 0 <= i; i--) {
            dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, dp1[i - 1] + dp2[i + 1]);
        }

        System.out.println(result);
    }
}
