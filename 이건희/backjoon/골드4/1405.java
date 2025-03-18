import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double result;
    static double[] arr;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new double[4];
        result = 0;
        visited = new boolean[30][30];

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }

        visited[15][15] = true;

        cal(15, 15, 0, 1.0);

        System.out.println(result);
    }

    public static void cal(int y, int x, int depth, double probability) {
        if (depth == N) {
            result += probability;

            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (0 <= ny && ny < 30 && 0 <= nx && nx < 30 && !visited[ny][nx]) {
                visited[ny][nx] = true;

                cal(ny, nx, depth + 1, probability * arr[i]);

                visited[ny][nx] = false;
            }
        }
    }
}
