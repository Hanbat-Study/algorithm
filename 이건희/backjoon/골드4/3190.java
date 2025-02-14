import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L, g, result;
    static int[][] map;
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static String[][] times;
    static Queue<String> queue;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        g = 0;
        result = 0;
        map = new int[N][N];
        queue = new LinkedList<>();
        set = new HashSet<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            map[y][x] = 1;
        }

        L = Integer.parseInt(br.readLine());
        times = new String[L][2];

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String time = st.nextToken();
            String d = st.nextToken();

            times[i][0] = time;
            times[i][1] = d;
        }

        queue.add("0,0");
        set.add("0,0");

        go(0, 0);

        System.out.println(result);
    }

    public static void go(int y, int x) {
        result++;

        int dy = y + dis[g][0];
        int dx = x + dis[g][1];
        String newHead = dy + "," + dx;

        if (dy < 0 || dy >= N || dx < 0 || dx >= N || set.contains(newHead)) return;

        queue.add(newHead);
        set.add(newHead);

        if (map[dy][dx] == 0) {
            String tail = queue.poll();
            set.remove(tail);
        } else map[dy][dx] = 0;

        for (int i = 0; i < L; i++) {
            if (Integer.parseInt(times[i][0]) == result) {
                if (times[i][1].equals("D")) g = (g + 1) % 4;
                else if (times[i][1].equals("L")) g = (g + 3) % 4;
                break;
            }
        }

        go(dy, dx);
    }
}
