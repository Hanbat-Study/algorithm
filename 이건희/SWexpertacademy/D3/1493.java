import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static int[] now(int[][] arr, int p) {
        int[] result = new int[2];
        for (int i = 1; i < 300; i++) {
            for (int j = 1; j < 300; j++) {
                if (arr[i][j] == p) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
 
        return result;
    }
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        int[][] arr = new int[300][300];
        int num = 0;
        for (int i = 1; i < 300; i++) {
            arr[1][i] = num + 1 + arr[1][i - 1];
            for (int j = 2; j < 300; j++) {
                arr[j][i] = arr[j - 1][i] + j + (num - 1);
            }
            num++;
        }
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
 
            int[] pd = now(arr, p);
            int[] qd = now(arr, q);
 
            int[] cal = {pd[0] + qd[0], pd[1] + qd[1]};
            int result = arr[cal[0]][cal[1]];
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
