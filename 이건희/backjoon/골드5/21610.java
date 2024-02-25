import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dis = {{0, -1} ,{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static ArrayList<int[]> clouds, newClouds;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        clouds = new ArrayList<>();
        int result = 0;

        clouds.add(new int[] {N - 1, 0});
        clouds.add(new int[] {N - 1, 1});
        clouds.add(new int[] {N - 2, 0});
        clouds.add(new int[] {N - 2, 1});

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            move(d, s);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += arr[i][j];
            }
        }

        System.out.println(result);

    }

    private static void move(int d, int s) {
        visited = new boolean[N][N];
        newClouds = new ArrayList<>();

        for (int[] cloud : clouds) {
            int dy = (cloud[0] + dis[d][0] * s + (100 / N + 1) * N) % N;
            int dx = (cloud[1] + dis[d][1] * s + (100 / N + 1) * N) % N;
            newClouds.add(new int[]{dy, dx});
        }

        for (int[] cloud : newClouds) {
            int dy = cloud[0];
            int dx = cloud[1];
            visited[dy][dx] = true;
            arr[dy][dx]++;
        }

        for (int[] cloud : newClouds) {
            int dy = cloud[0];
            int dx = cloud[1];

            for (int i = 0; i < 4; i++) {
                int ny = dy + dis[i * 2 + 1][0];
                int nx = dx + dis[i * 2 + 1][1];
                if (0 <= ny && ny < N && 0 <= nx && nx < N && 0 < arr[ny][nx]) {
                    arr[dy][dx]++;
                }
            }
        }

        clouds = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] >= 2) {
                    clouds.add(new int[]{i, j});
                    arr[i][j] -= 2;
                }
            }
        }
    }

}
