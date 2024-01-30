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
        	String str = br.readLine();
            int employees = 0;
            int applause = 0;
            for(int i = 0; i < str.length(); i++) {
                int n = str.charAt(i) - '0';
                if(i > applause) {
                    employees++;
                    applause++;
                }
                applause += n;
            }
            System.out.println("#" + test_case + " " + employees);
        }
	}
}
