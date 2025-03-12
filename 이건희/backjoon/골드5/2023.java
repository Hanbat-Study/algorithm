import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] startNums = {2, 3, 5, 7};

        for (int num : startNums) {
            check(num, 1);
        }
    }

    public static void check(int now, int length) {
        if (length == N) {
            System.out.println(now);

            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int nextNum = now * 10 + i;

            if (isPrime(nextNum)) check(nextNum, length + 1);
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;

        int sqrtNum = (int) Math.sqrt(num);

        for (int i = 2; i <= sqrtNum; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
