import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            int result = 0;
            char now = 'A';
 
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }
 
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[j].startsWith(String.valueOf(now))) {
                        result++;
                        now += 1;
                    }
                }
            }
 
            System.out.printf("#%d %s\n", test_case, result);
        }
    }
}
