import java.io.*;
import java.util.*;

public class Main {
    static int N, K, result, start, end;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        String s = br.readLine();
        start = 0;
        end = 0;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'P') {
                for (int j = -K; j <= K; j++) {
                    if (0 <= i + j && i + j < N && s.charAt(i + j) == 'H' && !visited[i + j]) {
                        result++;
                        visited[i + j] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
