import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            String word = br.readLine();
            boolean check = true;
 
            for (int i = 0; i < word.length() / 2; i++) {
                if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                    check = false;
                    break;
                }
            }
 
            if (check) {
                for (int i = 0; i < word.length() / 2 / 2; i++) {
                    if (word.charAt(i) != word.charAt(word.length() / 2 - 1 - i)) {
                        check = false;
                        break;
                    }
                }
 
                for (int i = 0; i < word.length() / 2 / 2; i++) {
                    if (word.charAt(word.length() / 2 + 1 + i) != word.charAt(word.length() - 1 - i)) {
                        check = false;
                        break;
                    }
                }
            }
 
            if (check) System.out.printf("#%d YES\n", test_case);
            else System.out.printf("#%d NO\n", test_case);
        }
    }
}
