import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            String word = br.readLine();
            long result = 1;
 
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (i == 0) {
                    if (ch != word.charAt(i + 1)) result *= 2;
                    else continue;
                }
                else if (i == word.length() - 1) {
                    if (ch != word.charAt(i - 1)) result *= 2;
                    else continue;
                }
                else {
                    if (ch != word.charAt(i + 1) && ch != word.charAt(i - 1) && word.charAt(i - 1) != word.charAt(i + 1)) result *= 3;
                    else if (ch == word.charAt(i - 1) && ch == word.charAt(i + 1) && word.charAt(i - 1) == word.charAt(i + 1)) continue;
                    else result *= 2;
                }
                 
                result %= 1000000007;
            }
            result %= 1000000007;
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
