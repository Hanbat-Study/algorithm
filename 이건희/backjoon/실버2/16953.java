import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int result = bfs();

        System.out.println(result);
    }

    public static int bfs() {
        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{A, 1});

        while (!q.isEmpty()) {
            long[] current = q.poll();
            long num = current[0];
            int cnt = (int)current[1];

            if (num == B) {
                return cnt;
            }

            if (num * 2 <= B) {
                q.offer(new long[]{num * 2, cnt + 1});
            }
            if (num * 10 + 1 <= B) {
                q.offer(new long[]{num * 10 + 1, cnt + 1});
            }
        }

        return -1;
    }
}
