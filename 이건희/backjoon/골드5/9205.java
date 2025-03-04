import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean flag;
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            n = Integer.parseInt(br.readLine());
            flag = true;
            arr = new int[n + 2][2];
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[i] = new int[]{x, y};
            }

            go();

            if (flag) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    public static void go() {
        Deque<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        q.add(0);

        while (!q.isEmpty()) {
            int curIdx = q.poll();
            int x = arr[curIdx][0];
            int y = arr[curIdx][1];

            if (curIdx == n + 1) {
                flag = true;
                return;
            }

            for (int i = 1; i < n + 2; i++) {
                if (!visited[i]) {
                    int nx = arr[i][0];
                    int ny = arr[i][1];

                    if (Math.abs(x - nx) + Math.abs(y - ny) <= 1000) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }

        flag = false;
    }
}
