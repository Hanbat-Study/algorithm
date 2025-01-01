import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 2; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.get(p).add(i);

            if (t == 'S') arr[i] = a;
            else arr[i] = a * -1;
        }

        dfs(1, 0);

        System.out.println(arr[1]);
    }

    public static void dfs(int now, int next) {
        for (int i = 0; i < list.get(now).size(); i++) {
            dfs(list.get(now).get(i), now);
        }

        if (0 < arr[now]) arr[next] += arr[now];
    }
}
