import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        boolean[] nums = new boolean[1000001];
        nums[0] = true;
        nums[1] = true;
        for (int l = 2; l < 1000001; l++) {
            for (int o = 2; o <= Math.sqrt(l); o++) {
                if (l % o == 0) {
                    nums[l] = true;
                    break;
                }
            }
        }
 
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int result = 0;
 
            for (int i = A; i <= B; i++) {
                boolean check = nums[i];
                int now = i;
                if (check == false) {
                    while (now > 0) {
                        if (now % 10 == D) {
                            result++;
                            break;
                        } else {
                            now /= 10;
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
