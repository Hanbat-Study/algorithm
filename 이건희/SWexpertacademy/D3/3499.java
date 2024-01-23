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
            int N = Integer.parseInt(br.readLine());
            int cnt;
            boolean check;
            if (N % 2 == 0) {
                cnt = N / 2;
                check = true;
            } else {
                cnt = N / 2 + 1;
                check = false;
            }
 
            String[] arr1 = new String[cnt];
            String[] arr2 = new String[N - cnt];
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                arr1[i] = st.nextToken();
            }
 
            for (int i = 0; i < N - cnt; i++) {
                arr2[i] = st.nextToken();
            }
 
            if (check) {
                for (int i = 0; i < cnt; i++) {
                    sb.append(arr1[i] + " ");
                    sb.append(arr2[i] + " ");
                }
            } else {
                for (int i = 0; i < cnt - 1; i++) {
                    sb.append(arr1[i] + " ");
                    sb.append(arr2[i] + " ");
                }
                sb.append(arr1[cnt - 1]);
            }
 
            System.out.printf("#%d %s\n", test_case, sb);
        }
    }
}
