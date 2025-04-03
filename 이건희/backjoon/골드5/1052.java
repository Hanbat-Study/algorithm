import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, cnt, num, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N <= K) {
            System.out.println(0);

            return;
        }

        while (true) {
            cnt = 0;
            int num = N;

            while (num != 0) {
                if (num % 2 == 1) cnt++;

                num /= 2;
            }

            if (cnt <= K) break;

            N++;
            result++;
        }

        System.out.println(result);
    }
}
