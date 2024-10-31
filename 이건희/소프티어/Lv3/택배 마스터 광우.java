import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, result;
    static int[] boxes, arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boxes = new int[N];
        arr = new int[N];
        visited = new boolean[N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0);

        System.out.println(result);
    }

    private static void permutation(int cnt) {
        if (cnt == N) {
            check();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static void check() {
        int now = 0;
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < K; i++) {
            while (sum + boxes[arr[now]] <= M) {
                sum += boxes[arr[now]];
                now = (now + 1) % N;
            }

            cnt += sum;
            sum = 0;
        }

        result = Math.min(result, cnt);
    }
}
