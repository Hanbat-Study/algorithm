import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, d, c, cnt, time;
    static int[] arr;
    static ArrayList<ArrayList<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < test; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            cnt = 0;
            time = 0;
            arr = new int[n + 1];
            list = new ArrayList<>();

            Arrays.fill(arr, Integer.MAX_VALUE);

            for (int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list.get(b).add(new int[]{a, s});
            }

            go(c);

            for (int i = 1; i <= n; i++) {
                if (arr[i] != Integer.MAX_VALUE) {
                    cnt++;

                    time = Math.max(time, arr[i]);
                }
            }

            System.out.println(cnt + " " + time);
        }
    }

    public static void go(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        arr[start] = 0;

        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowTime = cur[1];

            if (arr[now] < nowTime) continue;

            for (int i = 0; i < list.get(now).size(); i++) {
                int[] ints = list.get(now).get(i);
                int next = ints[0];
                int nextTime = nowTime + ints[1];

                if (nextTime < arr[next]) {
                    arr[next] = nextTime;

                    pq.add(new int[]{next, nextTime});
                }
            }
        }
    }
}
