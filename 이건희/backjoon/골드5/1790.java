import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int k = K;
        int cnt = 1;
        long num = 9;
        long sum = 0;

        if (K < 10) {
            System.out.println(K);

            return;
        }

        while (sum + cnt * num < K) {
            sum += cnt * num;
            cnt++;
            num *= 10;
        }

        long m = K - sum - 1;
        long n = (long) Math.pow(10, cnt - 1) + m / cnt;

        if (N < n) System.out.println(-1);
        else {
            String s = String.valueOf(n);
            System.out.println(s.charAt((int) (m % cnt)));
        }
    }
}
