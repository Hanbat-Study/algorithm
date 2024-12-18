import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());


            cal(2, 1, "1", 1);

            System.out.println();
        }
    }

    public static void cal(int num, int sum, String result, int prev) {
        if (N < num) {
            if (sum == 0) System.out.println(result);

            return;
        }

        int newPrev = prev > 0 ? prev * 10 + num : prev * 10 - num;

        cal(num + 1, sum + newPrev - prev, result + " " + num, newPrev);
        cal(num + 1, sum + num, result + "+" + num, num);
        cal(num + 1, sum - num, result + "-" + num, -num);
    }
}
