import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main_10026 {
    static int N;
    static boolean[][] visited;
    static String[][] c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        c = new String[N][];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++){
            String[] s = br.readLine().split("");
            c[i] = s;
        }
        int count = 0;
        int countP = 0;
        for (int i =0; i< N; i++) {
            for (int j = 0; j < N; j++) {
                if (c[i][j].equals("R") && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, "R");
                    count++;
                }
                else if (c[i][j].equals("B") && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, "B");
                    count++;
                }
                else if (c[i][j].equals("G") && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, "G");
                    count++;
                }
            }
        }
        for (int i = 0; i <N; i++){
            for (int j =0; j<N; j++) {
                if(c[i][j].equals("G")) c[i][j] = "R";
            }
        }
        visited = new boolean[N][N];
        for (int i =0; i< N; i++) {
            for (int j = 0; j < N; j++) {
                if (c[i][j].equals("R") && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, "R");
                    countP++;
                }
                else if (c[i][j].equals("B") && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, "B");
                    countP++;
                }
            }
        }
        System.out.printf("%d %d",count, countP);
    }

    private static void bfs(int x, int y, String color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx <0 || nx >= N || ny <0 || ny >=N) continue;
                if (c[nx][ny].equals(color) && !visited[nx][ny]) {


                    q.offer(new int[] {nx , ny});
                    visited[nx][ny] = true;
                }
            }

        }
    }

}