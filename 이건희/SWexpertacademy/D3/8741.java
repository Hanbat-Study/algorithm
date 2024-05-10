import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            String[] words = br.readLine().split(" ");
 
            StringBuilder sb = new StringBuilder();
 
            for (String word : words) {
                sb.append(String.valueOf(word.charAt(0)).toUpperCase());
            }
 
            System.out.printf("#%d %s\n", test_case, sb);
        }
    }
}
