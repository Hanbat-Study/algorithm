import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i][0] = d;
            arr[i][1] = t;
        }

        Arrays.sort(arr, (a, b) -> (b[1] != a[1]) ? Integer.compare(b[1], a[1]) : Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            if (arr[i][1] <= result) result = arr[i][1] - arr[i][0];
            else result -= arr[i][0];
        }

        System.out.println(result);
    }
}
