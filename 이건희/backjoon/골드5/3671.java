import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int c, result;
    static String[] pieces;
    static Set<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < c; test_case++) {
            pieces = br.readLine().split("");
            result = 0;
            numbers = new HashSet<>();
            boolean[] used = new boolean[pieces.length];

            generateNumbers("", used);

            System.out.println(result);
        }
    }

    static void generateNumbers(String current, boolean[] used) {
        if (!current.isEmpty()) {
            int num = Integer.parseInt(current);
            if (!numbers.contains(num) && isPrime(num)) {
                numbers.add(num);

                result++;
            }
        }

        for (int i = 0; i < pieces.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generateNumbers(current + pieces[i], used);
                used[i] = false;
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
