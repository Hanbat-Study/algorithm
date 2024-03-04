import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, K, result;
    static int[][] arr;
    static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int maxDeep = 0;
            result = 0;
            arr = new int[N][N];
            visited = new boolean[N][N];
 
            for (int i = 0; i < N; i++) {
                st  = new StringTokenizer(br.readLine());
 
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxDeep = Math.max(maxDeep, arr[i][j]);
                }
            }
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == maxDeep) go(i, j, 1, false);
                }
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    private static void go(int y, int x, int cnt, boolean check) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int dy = y + dis[i][0];
            int dx = x + dis[i][1];
 
            if (0 <= dy && dy < N && 0 <= dx && dx < N && !visited[dy][dx]) {
                if (!check) {
                    if (arr[dy][dx] < arr[y][x]) go(dy, dx, cnt + 1, false);
                    else {
                        for (int k = 1; k <= K; k++) {
                            if (arr[dy][dx] - k < arr[y][x]) {
                                int temp = arr[dy][dx];
                                arr[dy][dx] = arr[dy][dx] - k;
                                go(dy, dx, cnt + 1, true);
                                arr[dy][dx] = temp;
                                break;
                            }
                        }
                    }
                } else {
                    if (arr[dy][dx] < arr[y][x]) go(dy, dx, cnt + 1, true);
                }
            } else {
                result = Math.max(result, cnt);
            }
        }
        visited[y][x] = false;
    }
}
