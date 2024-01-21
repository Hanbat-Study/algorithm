import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            String[] arr = br.readLine().split( " ");
            int result = 0;
            int cnt = 0;
 
            for (int i = 0; i < N; i++) {
                if (arr[i].equals("0")) {
                    cnt++;
                }
                else {
                    result += cnt / D;
                    cnt = 0;
                }
            }
 
            result += cnt / D;
            System.out.printf("#%d %s\n", test_case, result);
        }
    }
}
