import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, M, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        result = cal(M) - cal(N - 1);

        System.out.println(result);
    }

    public static long cal(long num) {
        long cnt = 0;
        long now = 1;
        long pre = 0;

        while (true) {
            long val = num / now;

            if (0 < val) cnt += val * (now - pre);
            else break;

            pre = now;
            now *= 2;
        }

        return cnt;
    }
}
