import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
 
 
        for(int test_case = 1; test_case <= T; test_case++) {
            String[] s = br.readLine().split("");
            int result = 0;
            int clap = 0;
 
            for (int i = 0; i < s.length; i++) {
                int now = Integer.parseInt(s[i]);
 
                if (clap < i && now != 0) {
                    result += i - clap;
                    clap += i - clap;
                }
                clap += now;
            }
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
