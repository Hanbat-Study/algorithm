import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static int check(char c) {
        if ("CEFGHIJKLMNSTUVWXYZ".indexOf(String.valueOf(c)) != -1) {
            return 0;
        } else if ("ADOPQR".indexOf(String.valueOf(c)) != -1) {
            return 1;
        } else return 2;
    }
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            String result = "SAME";
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fw = st.nextToken();
            String sw = st.nextToken();
 
            if (fw.length() != sw.length()) {
                result = "DIFF";
            } else {
                for (int i = 0; i < fw.length(); i++) {
                    int fn = check(fw.charAt(i));
                    int sn = check(sw.charAt(i));
 
                    if (fn != sn) {
                        result = "DIFF";
                        break;
                    }
                }
            }
            System.out.printf("#%d %s\n", test_case, result);
        }
    }
}
