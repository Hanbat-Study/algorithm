import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean flag;
    static boolean[] visited;
    static long[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flag = false;
        visited = new boolean[N];
        arr = new long[N];
        result = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            cal(i, 0);
        }

        StringBuilder sb = new StringBuilder();

        for (long l : result) {
            sb.append(l).append(" ");
        }

        System.out.println(sb);
    }

    public static void cal(int num, int idx) {
        if (flag) return;

        if (!visited[num]) {
            visited[num] = true;
            long now = arr[num];
            result[idx] = now;

            if (idx == N - 1) {
                flag = true;

                return;
            }

            if (now % 3 == 0) {
                for (int i = num - 1; 0 <= i; i--) {
                    if (now / 3 == arr[i]) {
                        cal(i, idx + 1);

                        break;
                    }
                }
            }

            for (int i = num + 1; i < N; i++) {
                if (now * 2 == arr[i]) {
                    cal(i, idx + 1);

                    break;
                }
            }

            visited[num] = false;
        }
    }
}
