import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            set.add(find(i));
        }

        Object[] result = set.toArray();

        System.out.println(result[0] + " " + result[1]);
    }

    public static int find(int num) {
        if (num == arr[num]) return num;

        return arr[num] = find(arr[num]);
    }

    public static void union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A != B) arr[B] = A;
    }
}
