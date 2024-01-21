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
            StringBuilder result = new StringBuilder();
            String[][] arr = new String[N][];
 
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().split(" ");
            }
 
            int P = Integer.parseInt(br.readLine());
 
            for (int i = 0; i < P; i++) {
                int now = Integer.parseInt(br.readLine());
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (Integer.parseInt(arr[j][0]) <= now && now <= Integer.parseInt(arr[j][1])) {
                        cnt++;
                    }
                }
                result.append(String.valueOf(cnt) + " ");
            }
 
 
            System.out.printf("#%d %s\n", test_case, result);
        }
    }
}
