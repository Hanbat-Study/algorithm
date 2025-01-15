import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        visited = new boolean[N];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            cal(i, 0, 0);
        }

        System.out.println(result);
    }

    public static void cal(int teamA, int idx, int level) {
        if (level == teamA) {
            int startTeam = 0;
            int linkTeam = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) startTeam += arr[i][j] + arr[j][i];
                    else if (!visited[i] && !visited[j]) linkTeam += arr[i][j] + arr[j][i];
                }
            }

            result = Math.min(result, Math.abs(startTeam - linkTeam));

            return;
        }

        for (int i = idx; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;

            cal(teamA, i + 1, level + 1);

            visited[i] = false;
        }
    }
}
