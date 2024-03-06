import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, result;
    static int[][] arr;
    static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static ArrayList<int[]> list;
    static int maxCore;
    static int minLength;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            arr = new int[N][N];
            list = new ArrayList<>();
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
 
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
 
                    if (arr[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }
 
            maxCore = 0;
            minLength = Integer.MAX_VALUE;
            setLine(0, 0);
 
            System.out.printf("#%d %d\n", test_case, minLength);
        }
    }
 
    private static void setLine(int index, int core) {
        if (index == list.size()) {
            if (core > maxCore) {
                maxCore = core;
                minLength = Integer.MAX_VALUE;
            } else if (core == maxCore) {
                int len = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] == 2) len++;
                    }
                }
                minLength = Math.min(minLength, len);
            }
            return;
        }
 
        int[] cur = list.get(index);
        int x = cur[0];
        int y = cur[1];
 
        for (int i = 0; i < 4; i++) {
            int nx = x + dis[i][0];
            int ny = y + dis[i][1];
            boolean flag = true;
            int cnt = 0;
 
            while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (arr[nx][ny] != 0) {
                    flag = false;
                    break;
                }
                cnt++;
                nx += dis[i][0];
                ny += dis[i][1];
            }
 
            if (flag) {
                nx = x + dis[i][0];
                ny = y + dis[i][1];
                while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    arr[nx][ny] = 2;
                    nx += dis[i][0];
                    ny += dis[i][1];
                }
                setLine(index + 1, core + 1);
                nx = x + dis[i][0];
                ny = y + dis[i][1];
                while (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    arr[nx][ny] = 0;
                    nx += dis[i][0];
                    ny += dis[i][1];
                }
            }
        }
 
        setLine(index + 1, core);
    }
}
