import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, start, end, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        start = 0;
        end = n - 1;
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (Math.abs(sum) < Math.abs(result)) {
                result = sum;
            }

            if (0 < sum) end--;
            else start++;
        }

        System.out.println(result);
    }
}
