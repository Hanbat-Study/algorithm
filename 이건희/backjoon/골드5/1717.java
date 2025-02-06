import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == 1) {
                if (find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
            else union(a, b);
        }

        System.out.println(sb);
    }

    public static int find(int num) {
        if (num == arr[num]) return num;

        return arr[num] = find(arr[num]);
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) arr[pb] = pa;
    }
}
