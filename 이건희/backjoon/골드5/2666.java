import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[] open, targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        open = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 2; i++) {
            open[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(br.readLine());
        }

        cal(0, open[0], open[1], 0);

        System.out.println(result);
    }

    public static void cal(int idx, int o1, int o2, int moveCnt) {
        if (idx == M) {
            result = Math.min(result, moveCnt);

            return;
        }

        int target = targets[idx];

        cal(idx + 1, target, o2, moveCnt + Math.abs(o1 - target));

        cal(idx + 1, o1, target, moveCnt + Math.abs(o2 - target));
    }
}
