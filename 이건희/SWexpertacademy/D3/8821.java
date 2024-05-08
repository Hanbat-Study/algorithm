import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            String word =  br.readLine();
            arr = new int[10];
 
            for (int i = 0; i < word.length(); i++) {
                int num = word.charAt(i) - '0';
 
                arr[num]++;
            }
 
            int result = 0;
 
            for (int i = 0; i < 10; i++) {
                if (arr[i] % 2 == 1) result++;
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
