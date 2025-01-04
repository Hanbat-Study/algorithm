import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, result;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        result = new int[n + 1];
        list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (i == 1) continue;

            list.get(num).add(i);
        }

        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            result[i] += w;
        }

        dfs(1, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int now, int w) {
        result[now] += w;
        for (int i = 0; i < list.get(now).size(); i++) {
            int num = list.get(now).get(i);

            dfs(num, result[now]);
        }
    }
}
