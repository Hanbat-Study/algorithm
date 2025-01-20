import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean flag;
    static StringBuilder sb;
    static int[] result;
    static boolean[][] map, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        flag = false;
        sb = new StringBuilder();
        result = new int[N];
        map = new boolean[N][10];
        visited = new boolean[N][10];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][num] = true;
            }
        }

        cal(0, -1);

        if (flag) System.out.println(sb);
        else System.out.println(-1);
    }

    public static void cal(int depth, int pre) {
        if (flag) return;

        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append("\n");
            }

            flag = true;

            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (map[depth][i] && i != pre && !visited[depth][i] && !flag) {
                result[depth] = i;
                visited[depth][i] = true;

                cal(depth + 1, i);
            }
        }
    }
}
