import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static long N, P, Q, X, Y, result;
    static HashMap<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        map = new HashMap<>();

        map.put(0L, 1L);

        result = dp(N);

        System.out.println(result);
    }

    public static long dp(long n) {
        if (map.containsKey(n)) return map.get(n);

        long left = Math.max(0, n / P - X);
        long right = Math.max(0, n / Q - Y);
        long value = dp(left) + dp(right);

        map.put(n, value);

        return value;
    }
}
