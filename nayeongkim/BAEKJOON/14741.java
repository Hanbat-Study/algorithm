import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] population;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] parent; // 유니온 파인드를 위한 배열
    static boolean[] selected;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N + 1];
        parent = new int[N + 1];
        selected = new boolean[N + 1];
        graph = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            graph.add(new ArrayList<>());
        }
        graph.add(new ArrayList<>());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        divide(1);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    // idx번째 구역을 선택할지 말지 결정하며 모든 구역을 확인한 경우 검증
    private static void divide(int idx) {
        if (idx > N) {
            if (validate()) {
                cal();
            }
            return;
        }
        selected[idx] = true;
        divide(idx + 1);
        selected[idx] = false;
        divide(idx + 1);
    }

    // 선거구 분할이 유효한지 검증
    private static boolean validate() {
        int groupA = -1;
        int groupB = -1;

        for (int i = 1; i <= N; i++) {
            parent[i] = i; // 유니온 파인드 초기화
        }

        for (int i = 1; i <= N; i++) {
            for (int e : graph.get(i)) {
                if (selected[i] == selected[e]) {
                    union(i, e); // 같은 선거구에 속한 구역들을 연결
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (selected[i]) {
                if (groupA == -1) groupA = find(i);
                else if (groupA != find(i)) return false; // 두 구역이 다른 집합에 속한다면 연결되지 않은 것
            } else {
                if (groupB == -1) groupB = find(i);
                else if (groupB != find(i)) return false;
            }
        }

        return groupA != -1 && groupB != -1; // 두 선거구 모두 존재하는지 확인
    }

    // 유니온 파인드의 find 연산
    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    // 유니온 파인드의 union 연산
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }


    private static void cal() {
        int sumA = 0, sumB = 0;
        for (int i = 1; i <= N; i++) {
            if (selected[i]) sumA += population[i];
            else sumB += population[i];
        }
        res = Math.min(res, Math.abs(sumA - sumB));
    }
}
