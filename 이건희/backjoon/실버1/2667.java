import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> result = new ArrayList<>();
    static LinkedList<int[]> queue = new LinkedList<>();
    static int[][] arr;
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    result.add(bfs(i, j));
                }
            }
        }

        result.sort(null);
        System.out.println(result.size());
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static int bfs(int y, int x) {
        int cnt = 0;
        queue.offer(new int[]{y, x});
        arr[y][x] = 0;

        while (!queue.isEmpty()) {
            cnt++;
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dy = current[0] + dis[i][0];
                int dx = current[1] + dis[i][1];

                if (0 <= dy && dy < N && 0 <= dx && dx < N && arr[dy][dx] == 1) {
                    queue.offer(new int[]{dy, dx});
                    arr[dy][dx] = 0;
                }
            }
        }
        return cnt;
    }
}
