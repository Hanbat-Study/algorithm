import java.io.*;
import java.util.*;

public class Main {
    static int N, result;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        arr = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {P, C};
        }

        check(0, 0);
        
        System.out.println(result);
    }

    public static void check(int cnt, int now) {
        if (now == N) {
            result = Math.max(result, cnt);
            return;
        }

        if (Math.abs(arr[now][0] - cnt) <= arr[now][1]) {
            check(cnt + 1, now + 1);
        } else check(cnt, now + 1);
    }
}
