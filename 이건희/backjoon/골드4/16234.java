import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, cnt, result;
    static boolean flag;
    static int[][] map;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            flag = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) cal(i, j);
                }
            }

            if (!flag) break;

            result++;
        }

        System.out.println(result);
    }

    public static void cal(int y, int x) {
        Deque<int[]> q = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();
        visited[y][x] = true;
        int sum = map[y][x];

        q.add(new int[]{y, x});

        list.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int dy = now[0];
            int dx = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = dy + d[i][0];
                int nx = dx + d[i][1];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                    int diff = Math.abs(map[ny][nx] - map[dy][dx]);

                    if (L <= diff && diff <= R) {
                        visited[ny][nx] = true;
                        sum += map[ny][nx];

                        q.add(new int[]{ny, nx});

                        list.add(new int[]{ny, nx});
                    }
                }
            }
        }

        if (1 < list.size()) {
            flag = true;

            int avg = sum / list.size();

            for (int[] ints : list) {
                map[ints[0]][ints[1]] = avg;
            }
        }
    }
}
