import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_11724{
    static int N, M, result;
    static boolean[][] nums;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new boolean[N+1][N+1];
        visited = new boolean[N+1];
        result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nums[u][v] = nums[v][u] = true;
        }
        for(int i =1; i<=N; i++){
            if (!visited[i]) {
                count(i);
                result++;
            }
        }
        System.out.println(result);
    }

    private static void count(int cnt) {
        visited[cnt] = true;

        for(int i =1; i<=N;i++){
            if (nums[cnt][i] && !visited[i]) {
                //result++;
                count(i);

            }

        }
    }
}