import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M, weight, cost, result;
    static boolean flag;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weight = 0;
        cost = 0;
        result = Integer.MAX_VALUE;
        flag = false;
        map = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i][0] = a;
            map[i][1] = b;
        }

        Arrays.sort(map, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o2[0], o1[0]);
            }

            return Integer.compare(o1[1], o2[1]);
        });

        for (int i = 0; i < N; i++) {
            int nowWeight = map[i][0];
            int nowCost = map[i][1];

            weight += nowWeight;

            if (0 < i && map[i - 1][1] == nowCost) cost += nowCost;
            else cost = nowCost;

            if (M <= weight){
                result = Math.min(result, cost);
                flag = true;
            }
        }

        if (flag) System.out.println(result);
        else System.out.println(-1);
    }
}
