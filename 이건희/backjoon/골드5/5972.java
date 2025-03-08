import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static ArrayList<ArrayList<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        arr = new int[N + 1];

        Arrays.fill(arr, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new int[]{B, C});
            list.get(B).add(new int[]{A, C});
        }

        go(1);

        System.out.println(arr[N]);
    }

    public static void go(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        arr[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowCost = cur[1];

            if (arr[now] < nowCost) continue;

            for (int[] next : list.get(now)) {
                int nextNode = next[0];
                int nextCost = nowCost + next[1];

                if (nextCost < arr[nextNode]) {
                    arr[nextNode] = nextCost;

                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}
