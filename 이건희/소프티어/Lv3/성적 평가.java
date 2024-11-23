import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] scores, ranks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[4][N];
        ranks = new int[4][N];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int score = Integer.parseInt(st.nextToken());
                scores[i][j] = score;
                scores[3][j] += score;
            }
        }

        for (int i = 0; i < 4; i++) {
            cal(i);
        }

        for (int i = 0; i < 4; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < N; j++) {
                sb.append(ranks[i][j]);

                if (j != N - 1) sb.append(" ");
            }

            System.out.println(sb);
        }
    }

    public static void cal(int now) {
        int[][] sortedScores = new int[N][2];
        for (int i = 0; i < N; i++) {
            sortedScores[i][0] = scores[now][i];
            sortedScores[i][1] = i;
        }

        Arrays.sort(sortedScores, (a, b) -> b[0] - a[0]);

        int rank = 1;
        ranks[now][sortedScores[0][1]] = rank;

        for (int i = 1; i < N; i++) {
            if (sortedScores[i][0] < sortedScores[i-1][0]) {
                rank = i + 1;
            }
            
            ranks[now][sortedScores[i][1]] = rank;
        }
    }
}
