import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, cnt, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int start = 0;
        int now = 0;
        int sum = 0;
        cnt = 0;
        result = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (start < N) {
            if (sum < S && now < N) {
                sum += arr[now];
                now++;
                cnt++;
            } else {
                sum -= arr[start];
                start++;
                cnt--;
            }

            if (S <= sum) result = Math.min(cnt, result);
        }

        if (result == Integer.MAX_VALUE) result = 0;

        System.out.println(result);
    }
}
