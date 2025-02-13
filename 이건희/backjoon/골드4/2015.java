import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long sum, result;
    static HashMap<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;
        sum = 0;
        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());


        map.put(0L, 1L);

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            result += map.getOrDefault(sum - K, 0L);

            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        System.out.println(result);
    }
}
