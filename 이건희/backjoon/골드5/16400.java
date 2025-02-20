import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static long[] dp;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[40001];
        list = new ArrayList<>();

        dp[0] = 1;

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) list.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            for (int j = num; j <= N; j++) {
                dp[j] = (dp[j] + dp[j - num]) % 123456789;
            }
        }

        System.out.println(dp[N]);
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
