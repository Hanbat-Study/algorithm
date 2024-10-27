import java.io.*;
import java.util.*;

public class Main {
    static int[][] d = {{- 1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] arr;
    static int N, cnt;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    cnt = 1;
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }

        System.out.println(result.size());

        result.sort(Comparator.comparingInt(o -> o));

        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (0 <= ny && ny < N && 0 <= nx && nx < N && arr[ny][nx] == 1) {
                arr[ny][nx] = 0;
                cnt++;
                dfs(ny, nx);
            }
        }
    }
}
