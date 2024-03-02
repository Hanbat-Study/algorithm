import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, W, H, result;
    static int[] numbers;
    static int[][] arr, copyArr;
    static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;
            numbers = new int[N];
            arr = new int[H][W];
 
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
 
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            comb(0);
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    private static void comb(int cnt) {
        if (cnt == N) {
            copyArr = new int[H][];
 
            for (int i = 0; i < H; i++) {
                int[] newRow = new int[W];
                System.arraycopy(arr[i], 0, newRow, 0, W);
                copyArr[i] = newRow;
            }
 
            shoot();
 
            return;
        }
 
        for (int i = 0; i < W; i++) {
            numbers[cnt] = i;
            comb(cnt + 1);
        }
    }
 
    private static void shoot() {
        for (int i = 0; i < N; i++) {
            int n = numbers[i];
 
            for (int j = 0; j < H; j++) {
                if (0 < copyArr[j][n]) {
                    bomb(j, n, copyArr[j][n]);
                    break;
                }
            }
        }
 
        cal();
    }
 
    private static void cal() {
        int cnt = 0;
 
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (0 < copyArr[i][j]) cnt++;
            }
        }
 
        result = Math.min(result, cnt);
    }
 
    private static void bomb(int y, int x, int range) {
        LinkedList<int[]> queue = new LinkedList<>();
 
        queue.offer(new int[]{y, x, range});
        copyArr[y][x] = 0;
 
        while (!queue.isEmpty()) {
            int[] d = queue.poll();
 
            int ny = d[0];
            int nx = d[1];
            int nRange = d[2] - 1;
 
            if (nRange == 0) continue;
 
            for (int i = 0; i < 4; i++) {
                int dy = ny;
                int dx = nx;
 
                for (int j = 0; j < nRange; j++) {
                    dy += dis[i][0];
                    dx += dis[i][1];
 
                    if (0 <= dy && dy < H && 0 <= dx && dx < W && 0 < copyArr[dy][dx]) {
                        queue.offer(new int[]{dy, dx, copyArr[dy][dx]});
                        copyArr[dy][dx] = 0;
                    }
                }
            }
        }
 
        drop();
    }
 
    private static void drop() {
        for (int i = 0; i < W; i++) {
            for (int j = H - 1; 1 <= j; j--) {
                if (0 == copyArr[j][i] && 0 < copyArr[j - 1][i]) {
                    int temp = copyArr[j][i];
                    copyArr[j][i] = copyArr[j - 1][i];
                    copyArr[j - 1][i] = temp;
                    j = H;
                }
            }
        }
    }
}
