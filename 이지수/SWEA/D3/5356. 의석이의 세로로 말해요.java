import java.io.BufferedReader;
import java.io.InputStreamReader;
//p.m. 2 : 33 ~
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] str = new String[5];
            for(int i = 0; i < 5; i++){
            	str[i] = br.readLine();
            }
			System.out.printf("#" + test_case + " ");
            for(int i = 0; i < 15; i++) {
            	for(int j = 0; j < 5; j++) {
                	if(str[j].length() <= i)
                        continue;
                    System.out.printf("%c", str[j].charAt(i));
                }
            }
            System.out.println();
		}
	}
}
