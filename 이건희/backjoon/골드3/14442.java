import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K, result;
    static char[][] arr;
    static int[][][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new int[N][M][K + 1];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            arr[i] = s.toCharArray();
        }

        go();

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    public static void go() {
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int cnt = cur[2];
            int bomb = cur[3];

            if (y == N - 1 && x == M - 1) {
                result = Math.min(result, cnt);

                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + d[i][0];
                int nx = x + d[i][1];

                if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                    if (arr[ny][nx] == '0' && (visited[ny][nx][bomb] == 0 || cnt + 1 < visited[ny][nx][bomb])) {
                        visited[ny][nx][bomb] = cnt + 1;

                        q.add(new int[]{ny, nx, cnt + 1, bomb});
                    } else if (arr[ny][nx] == '1' && bomb < K && (visited[ny][nx][bomb + 1] == 0 || cnt + 1 < visited[ny][nx][bomb + 1])) {
                        visited[ny][nx][bomb + 1] = cnt + 1;

                        q.add(new int[]{ny, nx, cnt + 1, bomb + 1});
                    }
                }
            }
        }
    }
}
