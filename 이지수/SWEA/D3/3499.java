import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            String[] cards = br.readLine().split(" ");
            String[] result = new String[N];
            
            int idx1 = 0;
            int idx2;
            if(N % 2 == 0)
                idx2 = N/2;
            else
                idx2 = N/2 + 1;
            
            for(int i = 1; i < N + 1; i++) {
                if(i % 2 == 1) {
                    result[i - 1] = cards[idx1];
                    idx1++;
                }
                else {
                	result[i - 1] = cards[idx2];
                    idx2++;
                }
            }
            
            System.out.println("#" + test_case + " " + String.join(" ", result));
		}
	}
}
