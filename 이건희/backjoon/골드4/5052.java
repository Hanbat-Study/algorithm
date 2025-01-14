import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static boolean flag;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            n = Integer.parseInt(br.readLine());
            flag = true;
            arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);

            for (int i = 1; i < n; i++) {
                if (arr[i].startsWith(arr[i - 1])) {
                    flag = false;

                    break;
                }
            }

            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
