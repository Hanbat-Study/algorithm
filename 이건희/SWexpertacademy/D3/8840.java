import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            long num = Integer.parseInt(br.readLine());
            long result = (num / 2) * (num / 2);
 
 
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
