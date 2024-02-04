import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] bl = new boolean[100][100];
        int result = 0;
        int[][] dis = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int nx = 0;
        int ny = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    if (!bl[j][k]) {
                        bl[j][k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (bl[i][j]) {
                    for (int k = 0; k < 4; k++) {
                        nx = j + dis[k][1];
                        ny = i + dis[k][0];
                        if (nx < 0 || 100 < nx || ny < 0 || 100 < ny || !bl[ny][nx]) {
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
