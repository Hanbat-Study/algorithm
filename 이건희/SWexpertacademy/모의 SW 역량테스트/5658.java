import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, K;
    static String s;
    static HashSet<Integer> set;
    static ArrayList<Integer> list;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            set = new HashSet<>();
 
            s = br.readLine();
            s += s.substring(0, N / 4);
            cal();
 
            System.out.printf("#%d %d\n", test_case, list.get(K - 1));
        }
    }
 
    private static void cal() {
        for (int i = 0; i < N / 4; i++) {
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(s.substring(i + j * (N / 4), i + (j + 1) * (N / 4)), 16);
                set.add(n);
            }
        }
 
        list = new ArrayList<>(set);
 
        Collections.sort(list, Collections.reverseOrder());
    }
}
