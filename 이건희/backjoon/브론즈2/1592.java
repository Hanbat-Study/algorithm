import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sb = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sb.nextToken());
        int M = Integer.parseInt(sb.nextToken());
        int L = Integer.parseInt(sb.nextToken());
        int[] arr = new int[N];
        arr[0] = 0;
        int now = 0;
        int result = 0;

        while (true) {
            if (arr[now] + 1 < M) {
                arr[now]++;
            } else break;

            if (arr[now] % 2 == 0) {
                now -= L;
                if (now < 0) {
                    now += N;
                }
            } else {
                now += L;
                if (now > N - 1) {
                    now %= N;
                }
            }

            result++;
        }

        System.out.println(result);
    }
}
