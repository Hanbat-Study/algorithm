import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = 0;

        for (int i = 2; i <= n; i++) {
            result += (long) ((n - i) / i) * i;
        }

        System.out.println(result % 1000000);
    }
}
