import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, W, result;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        result = 0;
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.get(U).add(V);
            list.get(V).add(U);
        }

        go(1);

        System.out.println((double) W / result);
    }

    public static void go(int now) {
        visited[now] = true;
        ArrayList<Integer> nowList = list.get(now);
        boolean flag = false;

        for (int i = 0; i < nowList.size(); i++) {
            Integer next = nowList.get(i);

            if (!visited[next]) {
                go(next);

                flag = true;
            }
        }
        
        if (!flag) result++;
    }

}
