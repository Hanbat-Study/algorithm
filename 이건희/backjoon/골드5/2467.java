import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, left, right, cnt;
    static int[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = new int[]{arr[0], arr[N - 1]};

        for (int i = 0; i < N; i++) {
            left = i + 1;
            right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                int sum = arr[i] + arr[mid];

                if (Math.abs(sum) < cnt) {
                    result[0] = arr[i];
                    result[1] = arr[mid];
                    cnt = Math.abs(sum);
                }

                if (sum < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
