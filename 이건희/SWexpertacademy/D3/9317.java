import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
            result = 0;
 
            String word1 = br.readLine();
            String word2 = br.readLine();
 
            for (int i = 0; i < N; i++) {
                if (word1.charAt(i) == word2.charAt(i)) result++;
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
