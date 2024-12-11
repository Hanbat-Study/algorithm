import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long result;
    static int[] bags;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        bags = new int[K];
        result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            arr[i] = new int[] {M, V};
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(bags);

        int index = 0;

        for (int bag : bags) {
            while (index < N && arr[index][0] <= bag) {
                pq.add(arr[index][1]);
                index++;
            }

            if (!pq.isEmpty()) result += pq.poll();
        }

        System.out.println(result);
    }
}
