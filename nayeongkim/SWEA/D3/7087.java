import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.Arrays;

class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        for (int tc = 1 ; tc <= T; tc++) {
            int cnt = 0;
            char ascii = 'A';
            int N = Integer.parseInt(br.readLine());
            String[] strings = new String[N];
            for (int i = 0; i < N; i++) {
                strings[i] = String.valueOf(br.readLine().charAt(0));
            }
            Arrays.sort(strings);

            for(String s: strings) {
                if (s.equals(String.valueOf(ascii))) {
                    cnt++;
                    ascii++;
                }

            }
            System.out.printf("#%d %d\n",tc,cnt);

        }
    }
}