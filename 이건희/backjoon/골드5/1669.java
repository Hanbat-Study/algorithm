import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        diff = Y - X;
        long n = 0;

        if (diff == 0) {
            System.out.println(0);

            return;
        }

        while (n * n < diff) n++;

        if (n * n != diff) n--;

        long result = 2*n-1;
        diff -= n * n;

        while(0 < diff) {
            diff -= Math.min(n, diff);

            result++;
        }

        System.out.println(result);
    }
}
