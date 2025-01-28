import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int K, cnt, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        cnt = 0;
        sum = 0;

        while (sum + (1 << (cnt + 1)) < K) {
            cnt++;

            sum += (1 << cnt);
        }

        int now = cnt;
        K -= sum;
        int[] result = new int[now + 1];

        Arrays.fill(result, 4);

        while (0 < K && 0 <= now) {
            if (K % 2 == 0)  result[now] = 7;

            K = (K + 1) / 2;

            now--;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : result) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
