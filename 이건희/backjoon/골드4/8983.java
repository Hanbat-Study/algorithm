import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N, L, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cal(x, y);
        }

        System.out.println(result);
    }

    public static void cal(int x, int y) {
        int start = 0;
        int end = M - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            long len = Math.abs(arr[mid] - x) + y;

            if (len <= L) {
                result++;

                return;
            }

            if (x < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
    }
}
