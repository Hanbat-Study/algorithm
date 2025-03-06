import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, start, end;
    static int[] dist;
    static ArrayList<ArrayList<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new int[]{B, C});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        go();

        System.out.println(dist[end]);
    }

    public static void go() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        dist = new int[N + 1];
        dist[start] = 0;

        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowCost = cur[1];

            if (nowCost > dist[now]) continue;

            for (int[] next : list.get(now)) {
                int nextNode = next[0];
                int nextCost = nowCost + next[1];

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;

                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}
