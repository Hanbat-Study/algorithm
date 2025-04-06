import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X, result;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= N; i++) {
            cal(i, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        System.out.println(result);
    }

    public static void cal(int num, int sum, int idx, int min, int max) {
        if (idx == num) {
            if (X <= max - min && L <= sum && sum <= R) result++;

            return;
        }

        for (int i = idx; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            int minNum = Math.min(min, arr[i]);
            int maxNum = Math.max(max, arr[i]);

            cal(num, sum + arr[i], i + 1, minNum, maxNum);

            visited[i] = false;
        }
    }
}
