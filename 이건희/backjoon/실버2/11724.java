import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int i = 1; i < N + 1; i++) {
            if (visited[i]) {
                continue;
            }
            bfs(i);
            result++;
        }

        System.out.println(result);
    }

    private static void bfs(int i) {
        for (int n : list.get(i)) {
            if (!visited[n]) {
                visited[n] = true;
                bfs(n);
            }
        }
    }
}
