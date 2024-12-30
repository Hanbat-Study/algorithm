import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] arr;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[N][M];
        visited = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        go();

        if (result == 0) System.out.println(-1);
        else System.out.println(result);
    }

    public static void go() {
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ny = cur[0];
            int nx = cur[1];
            int nCnt = cur[2];
            int nBomb = cur[3];

            if (ny == N - 1 && nx == M - 1) {
                result = nCnt;

                return;
            }

            for (int i = 0; i < 4; i++) {
                int dy = ny + d[i][0];
                int dx = nx + d[i][1];

                if (0 <= dy && dy < N && 0 <= dx && dx < M) {
                    if (arr[dy][dx] == 0 && visited[dy][dx][nBomb] == 0) {
                        visited[dy][dx][nBomb] = 1;
                        q.add(new int[]{dy, dx, nCnt + 1, nBomb});
                    }

                    else if (arr[dy][dx] == 1 && nBomb == 0 && visited[dy][dx][1] == 0) {
                        visited[dy][dx][1] = 1;
                        q.add(new int[]{dy, dx, nCnt + 1, 1});
                    }
                }
            }
        }
    }
}
