import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t = Integer.parseInt(br.readLine());
         
        for (int test_case = 1; test_case <= t; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            boolean c = false;
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
            }
             
            int idx = 0;
            int num = 0;
             
            while (0 <= num && num <= Integer.MAX_VALUE) {
                boolean check = false;
                 
                for (int i = 0; i < N; i++) {
                    int now = arr[i];
                     
                    if (num - now < 0 || (num - now) % 2 != 0) {
                        check = true;
                        break;
                    }
                }
                 
                if (check) {
                    idx++;
                    num += idx;
                } else {
                    c = true;
                    break;
                }
            }
             
            if (!c) System.out.printf("#%d -1\n", test_case);
            else System.out.printf("#%d %d\n", test_case, idx);
        }
    }
}
