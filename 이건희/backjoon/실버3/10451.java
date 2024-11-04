import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        result = new int[T];

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            visited = new boolean[N];

            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken()) - 1;
            }

            result[i] = cal(arr);
        }

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static void check(int n, int[] arr) {
        visited[n] = true;
        int num = arr[n];

        if (visited[num]) return;

        check(num, arr);
    }

    public static int cal(int[] arr) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                check(i, arr);
                cnt++;
            }
        }

        return cnt;
    }
}
