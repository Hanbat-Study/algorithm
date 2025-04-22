import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long min;
    static long[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Long.MAX_VALUE;
        arr = new long[N];
        result = new long[3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (start == i) {
                    start++;

                    continue;
                } else if (end == i) {
                    end--;

                    continue;
                }

                long sum = arr[start] + arr[end] + arr[i];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    result = new long[]{arr[start], arr[end], arr[i]};
                }

                if (sum < 0) start++;
                else end--;
            }
        }

        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();

        for (long i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
