import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
 
class Solution {
    static String[] s;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            s = br.readLine().split("");
            HashSet<String> set = new HashSet<>();
             
            Long res = 1L;
            for (int i = 0; i < s.length; i++) {
                if (i == 0) {
                    set.add(s[i]);
                    set.add(s[i + 1]);
                }
                else if (i == s.length - 1) {
                    set.add(s[i - 1]);
                    set.add(s[i]);
                }
                else {
                    set.add(s[i-1]);
                    set.add(s[i]);
                    set.add(s[i + 1]);
                }
                res *= set.size();
                res %= (1000000007L);
                set.clear();
            }
            res %= 1000000007L;
            System.out.println("#" + t+ " " + res);
        }
    }
}
