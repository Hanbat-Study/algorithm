import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            result++;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (union(a, b)) {
                System.out.println(result);

                return;
            }
        }

        System.out.println(0);
    }

    public static int find(int num) {
        if (arr[num] == num) return num;

        return arr[num] = find(arr[num]);
    }

    public static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            arr[pb] = pa;

            return false;
        } return true;
    }
}
