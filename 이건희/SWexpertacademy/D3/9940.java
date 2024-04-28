import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int TC = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= TC; test_case++) {
            int N = Integer.parseInt(br.readLine());
            Integer[] arr = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
 
            Set<Integer> set = new HashSet<>(Arrays.asList(arr));
 
            if (set.size() == N) System.out.printf("#%d Yes\n", test_case);
            else System.out.printf("#%d No\n", test_case);
        }
    }
}
