import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main_2667{
    static int N, idx;
    static boolean[][] visitied;
    static int[][] nums;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visitied = new boolean[N][N];
        nums = new int[N][N];
        result = new int[N*N];
        for (int i = 0; i < N; i++) {
            String[] str= br.readLine().split("");
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(str[j]);
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j = 0; j<N;j++){
                if(!visitied[i][j] && nums[i][j] == 1) {
                    idx = 0;
                    apt(i, j);
                    result[count++] = idx;

                }
            }
        }
        Arrays.sort(result, 0, count);
        System.out.println(count);
        for(int i =0; i<count; i++) {
            System.out.println(result[i]);
        }

    }

    private static void apt(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visitied[x][y] = true;
        idx++;
        while(!q.isEmpty()) {
            int[] now= q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i =0;i<4;i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx<0||nx>=N||ny<0||ny>=N) continue;
                if(visitied[nx][ny] || nums[nx][ny] == 0) continue;
                q.add(new int[] {nx, ny});
                visitied[nx][ny] = true;
                idx++;

            }

        }
    }
}