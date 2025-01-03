import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[][] visited1, visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            visited1[a][b] = true;
            visited2[b][a] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (visited1[j][i] && visited1[i][k]) visited1[j][k] = true;
                    if (visited2[j][i] && visited2[i][k]) visited2[j][k] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (!visited1[i][j] && !visited2[i][j]) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
