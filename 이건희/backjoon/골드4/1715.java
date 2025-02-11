import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int N, result;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        pq = new PriorityQueue<>();

        if (N == 1) {
            System.out.println(0);

            return;
        }

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (2 <= pq.size()) {
            int sum = pq.poll() + pq.poll();

            result += sum;

            pq.add(sum);
        }

        System.out.println(result);
    }
}
