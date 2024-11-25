import java.io.*;
import java.util.*;

public class Main {
    static int H, W, Q;
    static int[][] arr;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            check(a, b, c);
        }


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(arr[i][j]);

                if (j != W - 1) sb.append(" ");
            }

            if (i != H - 1)sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void check(int a, int b, int c) {
        boolean[][] visited = move(a, b, arr[a][b]);
        transfer(visited, c);
    }

    public static boolean[][] move(int y, int x, int n) {
        Queue<Integer[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];

        q.offer(new Integer[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Integer[] p = q.poll();
            int dy = p[0];
            int dx = p[1];

            for (int i = 0; i < 4; i++) {
                int ny = dy + d[i][0];
                int nx = dx + d[i][1];

                if (0 <= ny && ny < H && 0 <= nx && nx < W && !visited[ny][nx] && arr[ny][nx] == n) {
                    visited[ny][nx] = true;
                    q.offer(new Integer[]{ny, nx});
                }
            }
        }

        return visited;
    }

    public static void transfer(boolean[][] visited, int a) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j]) arr[i][j] = a;
            }
        }
    }
}
