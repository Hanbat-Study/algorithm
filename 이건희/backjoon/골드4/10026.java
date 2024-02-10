import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int N;
    static String[][] arr;
    static boolean[][] visited;
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N][];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            arr[i] = s;
        }

        visited = new boolean[N][N];
        int result1 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result1++;
                }

                if (arr[i][j].equals("G")) {
                    arr[i][j] = "R";
                }
            }
        }

        visited = new boolean[N][N];
        int result2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    result2++;
                }
            }
        }

        System.out.printf("%d %d", result1, result2);
    }

    private static void bfs(int y, int x) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] d = queue.poll();
            int nx = d[1];
            int ny = d[0];

            for (int i = 0; i < 4; i++) {
                int dx = nx + dis[i][1];
                int dy = ny + dis[i][0];

                if (0 <= dx && dx < N && 0 <= dy && dy < N && arr[y][x].equals(arr[dy][dx]) && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    queue.offer(new int[] {dy, dx});
                }
            }
        }
    }
}
