import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N * 2];
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            for (int i = 0; i < N * 2; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
 
            for (int i = 1; i < N * 2; i++) {
                int now = arr[i];
 
                for (int j = 0; j < i; j++) {
                    if (arr[j] == now * 0.75) {
                        sb.append(arr[j]).append(" ");
                        arr[j] = 0;
                        arr[i] = 0;
                        break;
                    }
                }
            }
 
            System.out.printf("#%d %s\n", test_case, sb);
        }
    }
}
