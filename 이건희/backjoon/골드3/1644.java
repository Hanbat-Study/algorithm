import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N, result;
    static boolean[] prime;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        list = new ArrayList<>();
        prime = new boolean[N + 1];
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= N; j += i) prime[j] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!prime[i]) list.add(i);
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        while (true) {
            if (N <= sum) {
                sum -= list.get(start);
                start += 1;
            } else if (end == list.size()) break;
            else {
                sum += list.get(end);
                end += 1;
            }

            if (sum == N) result += 1;
        }

        System.out.println(result);
    }
}
