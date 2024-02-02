
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1260 {
    static int N, M, V;
    static int[] ouput;
    static boolean[][] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        nums = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        for(int i =0; i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nums[x][y] = nums[y][x] = true;
        }
        dfs(V);
        visited = new boolean[N+1];
        System.out.println();
        bfs(V);
    }
    private static void dfs(int cnt) {
        visited[cnt] = true;
        System.out.print(cnt+" ");
        for(int i=1;i<=N; i++) {
            if(nums[cnt][i] &&!visited[i]) {
                dfs(i);
            }
        }
    }
    private static void bfs(int cnt) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(cnt);
        visited[cnt] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");
            for(int i=1;i<=N;i++) {
                if(nums[cur][i] &&!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }

        }


    }

}