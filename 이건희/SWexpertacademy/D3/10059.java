import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            String date = br.readLine();
 
            int d1 = Integer.parseInt(date.substring(0, 2));
            int d2 = Integer.parseInt(date.substring(2, 4));
 
 
            if (0 < d1 && d1 < 13 && 0 < d2 && d2 < 13) {
                System.out.printf("#%d AMBIGUOUS\n", test_case);
            } else if ((d1 == 00 || 13 <= d1) && (0 < d2 && d2 < 13)) {
                System.out.printf("#%d YYMM\n", test_case);
            } else if ((0 < d1 && d1 < 13) && (d2 == 00 || 13 <= d2)) {
                System.out.printf("#%d MMYY\n", test_case);
            } else System.out.printf("#%d NA\n", test_case);
        }
    }
}
