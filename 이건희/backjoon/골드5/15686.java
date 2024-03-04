import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static boolean[] ck;
    static ArrayList<int[]> chickens, house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        chickens = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (s[j].equals("2")) {
                    chickens.add(new int[]{i, j});
                } else if (s[j].equals("1")) {
                    house.add(new int[]{i, j});
                }
            }
        }
        ck = new boolean[chickens.size()];

        check(0, 0);

        System.out.println(result);

    }

    private static void check(int idx, int cnt) {
        if (cnt == M) {
            int sum = 0;

            for (int[] h : house) {
                int dist = Integer.MAX_VALUE;

                for (int i = 0; i < chickens.size(); i++) {
                    if (ck[i]) {
                        dist = Math.min(dist, Math.abs(chickens.get(i)[0] - h[0]) + Math.abs(chickens.get(i)[1] - h[1]));
                    }
                }
                sum += dist;
            }
            result = Math.min(result, sum);
            return;
        }

        if (idx == chickens.size()) return;

        ck[idx] = true;
        check(idx + 1, cnt + 1);
        ck[idx] = false;
        check(idx + 1, cnt);
    }
}
