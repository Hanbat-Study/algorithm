import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static long sum;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        sum = 0;
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{X, A};
            sum += A;
        }

        Arrays.sort(arr, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        long middle = (sum + 1) / 2;
        sum = 0;

        for (int i = 0; i < N; i++) {
            if (middle <= arr[i][1] + sum) {
                result = arr[i][0];

                break;
            } sum += arr[i][1];
        }


        System.out.println(result);
    }
}
