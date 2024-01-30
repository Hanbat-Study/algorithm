import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String num = br.readLine();
            char now = '0';
            int result = 0;
             
            for (int i = 0; i < num.length(); i++) {
                if (now !=  num.charAt(i)) {
                    result++;
                    now = num.charAt(i);
                }
            }
             
            System.out.printf("#%d %d\n" , test_case, result);
        }
    }
}
