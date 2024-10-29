import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] limit = new int[101];
        int now = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for (int j = now; j < now + h; j++) {
                limit[j] = s;
            }

            now += h;
        }

        now = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for (int j = now; j < now + h; j++) {
                if (limit[j] < s) result = Math.max(result, s - limit[j]);
            }

            now += h;
        }

        System.out.println(result);
    }
}
