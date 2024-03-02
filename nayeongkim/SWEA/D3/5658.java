import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Solution_5658 {
    static int n, k;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();
            int r = n / 4;
            String s = br.readLine();
            String subs = s.substring(0, r);
            String res = s + subs;
            for (int i = 0; i < r; i++) {
                for (int j = i; j< n; j+= r) {
                    set.add(Integer.parseInt(res.substring(j, j + r), 16));
                }

            }
            ArrayList<Integer> arr = new ArrayList<>(set);
            Collections.sort(arr);
            Collections.reverse(arr);
            System.out.println("#" + tc + " " +arr.get(k - 1));

        }
    }
}