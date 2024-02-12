import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H, result;
    static int[][][] arr;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[][] dis = {{0, 0, 1}, {0, 0, -1}, {0, -1, 0}, {0, 1, 0}, {1, 0, 0}, {-1, 0, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        result = 1;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        list.add(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }

        System.out.println(result - 1);
    }

    private static void bfs() {
        LinkedList<int[]> queue = new LinkedList<>();

        for (int[] d : list) {
            queue.offer(d);
        }

        while (!queue.isEmpty()) {
            int[] d = queue.poll();
            int nh = d[0];
            int nn = d[1];
            int nm = d[2];

            for (int i = 0; i < 6; i++) {
                int dh = nh + dis[i][0];
                int dn = nn + dis[i][1];
                int dm = nm + dis[i][2];

                if (0 <= dh && dh < H && 0 <= dn && dn < N && 0 <= dm && dm < M && arr[dh][dn][dm] == 0) {
                    arr[dh][dn][dm] = arr[nh][nn][nm] + 1;
                    queue.offer(new int[]{dh, dn, dm});
                }
            }
        }
    }
}
