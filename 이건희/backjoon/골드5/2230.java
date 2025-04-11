import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, start, end, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        start = 0;
        end = 0;

        Arrays.sort(arr);

        while (end < N) {
            if (M <= arr[end] - arr[start]) {
                result = Math.min(result, arr[end] - arr[start]);

                start++;
            } else end++;

            if (start == end) end++;
        }

        System.out.println(result);
    }
}
