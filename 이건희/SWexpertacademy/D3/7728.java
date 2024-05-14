import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
 
public class Solution {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            String[] X = br.readLine().split("");
            Set<String> words = new HashSet<>(Arrays.asList(X));
 
            result = words.size();
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
