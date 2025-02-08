import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
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

        cal(R);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());

            System.out.println(arr[U]);
        }
    }

    public static void cal(int U) {
        arr[U] = 1;
        visited[U] = true;

        for (int i = 0; i < list.get(U).size(); i++) {
            int now = list.get(U).get(i);

            if (!visited[now]) {
                cal(now);

                arr[U] += arr[now];
            }

        }
    }
}
