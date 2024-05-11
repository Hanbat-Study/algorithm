import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            int n = Integer.parseInt(br.readLine()) * 2;
 
            int h = n / 60;
            int m = n % 60;
 
            System.out.printf("#%d %d %d\n", test_case, h, m);
        }
    }
}
