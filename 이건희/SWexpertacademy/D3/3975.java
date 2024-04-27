import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            double A = Integer.parseInt(st.nextToken());
            double B = Integer.parseInt(st.nextToken());
            double C = Integer.parseInt(st.nextToken());
            double D = Integer.parseInt(st.nextToken());
 
            if (A / B == C / D) {
                System.out.printf("#%d DRAW\n", test_case);
            } else if (A / B > C / D) {
                System.out.printf("#%d ALICE\n", test_case);
            } else System.out.printf("#%d BOB\n", test_case);
        }
    }
}
