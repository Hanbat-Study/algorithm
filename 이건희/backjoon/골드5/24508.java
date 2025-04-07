import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K, T, start, end, sum;
    static boolean result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        result = true;
        start = 0;
        end = N - 1;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (start < end) {
            if (T <= 0) break;

            if (K < arr[start] + arr[end]) {
                T -= K - arr[end];
                arr[start] -= K - arr[end];
                arr[end] = 0;
                end--;
            } else if (K == arr[start] + arr[end]) {
                T -= arr[start];
                arr[start] = 0;
                arr[end] = 0;
                start++;
                end--;
            } else {
                T -= arr[start];
                arr[end] += arr[start];
                arr[start] = 0;
                start++;
            }
        }

        if (T < 0) result = false;
        else {
            for (int i : arr) {
                if (0 < i) {
                    result = false;

                    break;
                }
            }
        }

        if (result) System.out.println("YES");
        else System.out.println("NO");
    }
}
