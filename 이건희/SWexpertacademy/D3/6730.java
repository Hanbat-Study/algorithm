import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int maxNum, minNum;
    static int[] arr;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            maxNum = 0;
            minNum = 0;
            arr = new int[N];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
 
            for (int i = 1; i < N; i++) {
                int n = arr[i] - arr[i - 1];
 
                if (0 < n && maxNum < n) maxNum = n;
                else if (n < 0 && minNum < Math.abs(n)) minNum = Math.abs(n);
            }
 
            System.out.printf("#%d %d %d\n", test_case, maxNum, minNum);
        }
    }
}
