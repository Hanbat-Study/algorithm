import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
 
 
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] token = br.readLine().split("");
            int range = token.length / 3;
            String result = "";
            int[] S = new int[14];
            int[] D = new int[14];
            int[] H = new int[14];
            int[] C = new int[14];
 
            int s_cnt = 13;
            int d_cnt = 13;
            int h_cnt = 13;
            int c_cnt = 13;
 
            for (int i = 0; i < range; i++) {
                String pattern = token[i * 3];
                int num = Integer.parseInt(token[i * 3 + 1] + token[i * 3 + 2]);
                if (pattern.equals("S")) {
                    if (S[num] == 0) {
                        S[num]++;
                        s_cnt--;
                    } else {
                        result = "ERROR";
                        break;
                    }
                } else if (pattern.equals("D")) {
                    if (D[num] == 0) {
                        D[num]++;
                        d_cnt--;
                    } else {
                        result = "ERROR";
                        break;
                    }
                } else if (pattern.equals("H")) {
                    if (H[num] == 0) {
                        H[num]++;
                        h_cnt--;
                    } else {
                        result = "ERROR";
                        break;
                    }
                } else if (pattern.equals("C")) {
                    if (C[num] == 0) {
                        C[num]++;
                        c_cnt--;
                    } else {
                        result = "ERROR";
                        break;
                    }
                }
            }
 
            if (result.equals("ERROR")) {
                System.out.printf("#%d ERROR\n", test_case);
            } else System.out.printf("#%d %d %d %d %d\n",test_case, s_cnt, d_cnt, h_cnt, c_cnt);
        }
    }
}
