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
            int result = 0;
            int num = 1;
            for(int i = 0; i < N; i++) {
             	String ground = br.readLine();
                result += ground.charAt(N/2) - '0';
                for(int j = N/2 + 1; j < N/2 + num; j++)
                    result += ground.charAt(j) - '0';
                for(int j = N/2 - 1; j > N/2 - num; j--)
                    result += ground.charAt(j) - '0';
                
                if(i > N/2 - 1)
                    num--;
                else
                    num++;
            }    
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}
