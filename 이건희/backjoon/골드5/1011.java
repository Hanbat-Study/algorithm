import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x, y, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            result = 0;
            int d = y - x;
            int maxNum = (int) Math.sqrt(d);

            if (maxNum == Math.sqrt(d)) result = 2 * maxNum - 1;
            else if (d <= maxNum * maxNum + maxNum) result = maxNum * 2;
            else result = maxNum * 2 + 1;

            System.out.println(result);
        }
    }
}
