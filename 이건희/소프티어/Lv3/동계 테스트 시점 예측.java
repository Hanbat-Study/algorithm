import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result;
    static int[][] arr, visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check();

        System.out.println(result);
    }

    public static void check() {
        while (true) {
            int cnt = 0;
            visited = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) {
                        cnt++;
                        bfs();
                    }
                }
            }

            if (cnt == 0) return;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (2 <= visited[i][j]) arr[i][j] = 0;
                }
            }

            result++;
        }
    }

    public static void bfs() {
        Queue<Integer[]> q = new LinkedList<>();

        q.offer(new Integer[]{0, 0});
        visited[0][0] = 1;

        while (!q.isEmpty()) {
            Integer[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + d[i][0];
                int nx = cur[1] + d[i][1];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (arr[ny][nx] == 1) {
                        visited[ny][nx]++;
                    } else if (arr[ny][nx] == 0 && visited[ny][nx] == 0) {
                        visited[ny][nx] = 1;
                        q.offer(new Integer[]{ny, nx});
                    }
                }
            }
        }
    }
}
