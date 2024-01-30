import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder result = new StringBuilder();
            String[][] arr = new String[5][];
            int max = 0;
 
            for (int i = 0; i < 5; i++) {
                String[] s= br.readLine().split("");
                arr[i] = s;
                max = Math.max(s.length, max);
            }
 
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < 5; j++) {
                    if (i <= arr[j].length - 1) {
                        result.append(arr[j][i]);
                    }
                }
            }
 
            System.out.printf("#%d %s\n", test_case, result);
        }
    }
}
