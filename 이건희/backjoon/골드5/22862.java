import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, start, end, jump, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        start = 0;
        end = 0;
        jump = 0;
        result = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (end = 0; end < N; end++) {
            if (arr[end] % 2 != 0) jump++;

            while (jump > K) {
                if (arr[start] % 2 != 0) jump--;

                start++;
            }

            result = Math.max(result, end - start + 1 - jump);
        }

        System.out.println(result);
    }
}
