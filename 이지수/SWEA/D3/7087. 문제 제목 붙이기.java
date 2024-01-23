import java.io.BufferedReader;
import java.io.InputStreamReader;
//p.m. 4:59~
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            boolean[] alphabets = new boolean[26];
            int result = 0;
            
            for(int i = 0; i < N; i++) {
                int idx = br.readLine().charAt(0) - 'A';
                alphabets[idx] = true;
            }
            for(int i = 0; i < 26; i++) {
            	if(alphabets[i])
                    result++;
                else
                    break;
            }
            System.out.println("#" + test_case + " " + result);
		}
	}
}
