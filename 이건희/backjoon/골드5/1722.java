import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static long[] factorial;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        factorial = new long[N + 1];
        visited = new boolean[N + 1];
        factorial[0] = 1;

        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        if (st.nextToken().equals("1")) {
            long k = Long.parseLong(st.nextToken());

            cal1(k);
        } else {
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            cal2(arr);
        }
    }

    public static void cal1(long k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;

                if (factorial[N - i - 1] < k) k -= factorial[N - i - 1];
                else {
                    sb.append(j).append(" ");

                    visited[j] = true;

                    break;
                }
            }
        }

        System.out.println(sb);
    }

    public static void cal2(int[] arr) {
        long num = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < arr[i]; j++) {
                if (!visited[j]) num += factorial[N - i - 1];
            }

            visited[arr[i]] = true;
        }

        System.out.println(num);
    }
}
