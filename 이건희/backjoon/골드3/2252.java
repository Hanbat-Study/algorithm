import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            arr[B]++;
        }

        Deque<Integer> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (arr[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            Integer now = q.poll();

            sb.append(now).append(" ");

            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);

                arr[next]--;

                if (arr[next] == 0) q.add(next);
            }
        }

        System.out.println(sb);
    }
}
