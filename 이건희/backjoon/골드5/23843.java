import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, now, result;
    static Integer[] arr;
    static PriorityQueue<Integer> pq, newPq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        now = 0;
        result = 0;
        arr = new Integer[N];
        st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < Math.min(M, N); i++) {
            pq.add(arr[i]);
            now++;
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();

            result += num;

            PriorityQueue<Integer> newPq = new PriorityQueue<>();

            while (!pq.isEmpty()) {
                int n = pq.poll() - num;
                if (n > 0) newPq.add(n);
            }

            while (newPq.size() < M && now < N) {
                newPq.add(arr[now]);
                now++;
            }

            pq = newPq;
        }

        System.out.println(result);
    }
}
