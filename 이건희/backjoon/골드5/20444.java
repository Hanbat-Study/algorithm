import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long n, k;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        flag = false;

        cal();

        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void cal() {
        long left = 0;
        long right = n / 2;
        while(left <= right) {
            long row = (left + right) / 2;
            long col = n - row;
            long total = (row + 1) * (col + 1);

            if(total == k) {
                flag = true;

                return;
            } else if(k < total) right = row - 1;
            else left = row + 1;
        }
    }
}
