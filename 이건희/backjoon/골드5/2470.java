import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, sum;
    static int[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        result = new int[]{arr[0], arr[N - 1]};
        sum = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        cal(0, N - 1);

        System.out.println(result[0] + " " + result[1]);
    }

    public static void cal(int start, int end) {
        if (start == end) return;

        if (Math.abs(arr[start] + arr[end]) < sum) {
            sum = Math.abs(arr[start] + arr[end]);
            result[0] = arr[start];
            result[1] = arr[end];
        }

        if (Math.abs(arr[start + 1] + arr[end]) <= Math.abs(arr[start] + arr[end - 1])) cal(start + 1, end);
        else cal(start, end - 1);
    }
}
