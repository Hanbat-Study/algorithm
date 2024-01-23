import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long max = 0;
        long min = 0;
        long mid = 0;
        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = (max < arr[i]) ? arr[i] : max;
        }

        max++;

        while (min < max) {
            mid = (min + max) / 2;
            long cnt = 0;

            for (int num : arr) {
                cnt += num / mid;
            }

            if (cnt < N) {
                max = mid;
            } else min = mid + 1;
        }

        System.out.println(min - 1);

    }
}
