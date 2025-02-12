import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        arr = new int[M];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < M; i++) {
            if (find(arr[i]) != find(arr[0])) {
                System.out.println("NO");

                return;
            }
        }

        System.out.println("YES");
    }

    public static int find(int num){
        if (num == parent[num]) return num;

        return parent[num] = find(parent[num]);
    }

    public static void union(int i, int j){
        int x = find(i);
        int y = find(j);

        if (x == y) return;

        parent[y] = x;
    }
}
