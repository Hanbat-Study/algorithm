import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        
		int alphabets[] = { 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] strs = br.readLine().split(" ");
            boolean result = true;
            
            if(strs[0].length() != strs[1].length()) {
                System.out.println("#" + test_case + " DIFF");
                continue;
            }
            
            for(int i = 0; i < strs[0].length(); i++) {
                int idx1 = strs[0].charAt(i) - 'A';
                int idx2 = strs[1].charAt(i) - 'A';
             	if(alphabets[idx1] != alphabets[idx2]) {
                 	result = false;
                    break;
                }
            }
            
            if(result)
                System.out.println("#" + test_case + " SAME");
            else
                System.out.println("#" + test_case + " DIFF");
		}
	}
}
