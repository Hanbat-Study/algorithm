import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] arr;
    static int[][] fire, visited;
    static Deque<int[]> q1, q2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        fire = new int[R][C];
        visited = new int[R][C];
        result = 0;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(fire[i], -1);
            Arrays.fill(visited[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String s = br.readLine();

            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);

                if (arr[i][j] == 'J') {
                    q1.add(new int[] {i, j});
                    visited[i][j] = 0;
                }
                else if (arr[i][j] == 'F') {
                    q2.add(new int[] {i, j});
                    fire[i][j] = 0;
                }
            }
        }

        go();

        if (result == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(result);
    }

    private static void go() {
        while (!q2.isEmpty()) {
            int[] cur = q2.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int dy = y + d[i][0];
                int dx = x + d[i][1];

                if (0 <= dy && dy < R && 0 <= dx && dx < C && arr[dy][dx] != '#' && fire[dy][dx] == -1) {
                    fire[dy][dx] = fire[y][x] + 1;

                    q2.add(new int[] {dy, dx});
                }

            }
        }

        while (!q1.isEmpty()) {
            int[] cur = q1.poll();
            int y = cur[0];
            int x = cur[1];

            for (int i = 0; i < 4; i++) {
                int dy = y + d[i][0];
                int dx = x + d[i][1];

                if (dy < 0 || R <= dy || dx < 0 || C <= dx) {
                    result = visited[y][x] + 1;

                    return;
                }

                if (arr[dy][dx] != '#' && visited[dy][dx] == -1 && (fire[dy][dx] == -1 || visited[y][x] + 1 < fire[dy][dx])) {
                    visited[dy][dx] = visited[y][x] + 1;

                    q1.add(new int[] {dy, dx});
                }

            }
        }
    }
}
