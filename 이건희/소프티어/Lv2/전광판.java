import java.io.*;
import java.util.*;

public class Main {
    static int[][] nums = {{1, 1, 1, 0, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 0, 1, 0}, {1, 1, 0, 1, 0, 1, 1}, {1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < t; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = 0;

            for (int i = 0; i < 5; i++) {
                if (A == 0 && B == 0) break;

                int a = 0;
                int b = 0;

                if (A == 0) a = 10;
                else  a = A % 10;

                if (B == 0) b = 10;
                else b = B % 10;

                for (int j = 0; j < 7; j++) {
                    if (nums[a][j] != nums[b][j]) result++;
                }

                A /= 10;
                B /= 10;
            }

            System.out.println(result);
        }
    }
}
