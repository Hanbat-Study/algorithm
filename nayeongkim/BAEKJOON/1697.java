import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Main_1697 {
    static int N, K;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        visited = new boolean[100001];
        distance = new int[100001];

        bfs(N);
        System.out.println(distance[K]);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) break;

            int[] nextMoves = {now - 1, now+ 1, now* 2};

            for (int i = 0; i < 3; i++) {
                int next = nextMoves[i];

                if (next >= 0 && next < 100001 && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    distance[next] = distance[now] + 1;
                }
            }
        }
    }
}