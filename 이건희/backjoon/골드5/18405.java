import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int K, N, S, X, Y;
    static int[][] arr;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (0 < arr[i][j]) list.add(new int[]{arr[i][j], i, j, 0});
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        list.sort(Comparator.comparingInt(a -> a[0]));

        cal();

        System.out.println(arr[X][Y]);
    }

    public static void cal() {
        Queue<int[]> queue = new LinkedList<>(list);

        while (!queue.isEmpty()) {
            int[] virus = queue.poll();
            int type = virus[0];
            int y = virus[1];
            int x = virus[2];
            int time = virus[3];

            if (time == S) return;

            for (int[] dir : d) {
                int ny = y + dir[0];
                int nx = x + dir[1];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && arr[ny][nx] == 0) {
                    arr[ny][nx] = type;

                    queue.add(new int[]{type, ny, nx, time + 1});
                }
            }
        }
    }
}
