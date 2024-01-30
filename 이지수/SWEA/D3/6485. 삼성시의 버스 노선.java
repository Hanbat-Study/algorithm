import java.io.BufferedReader;
import java.io.InputStreamReader;
//p.m. 4:28~
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            int[][] ab = new int[2][N];
            for(int i = 0; i < N; i++) {
             	String[] str = br.readLine().split(" ");
                ab[0][i] = Integer.parseInt(str[0]);
                ab[1][i] = Integer.parseInt(str[1]);
            }
            
            int P = Integer.parseInt(br.readLine());
            int[] result = new int[P];
            for(int i = 0; i < P; i++) {
                int C = Integer.parseInt(br.readLine());
                for(int j = 0; j < N; j++) {
                	if(ab[0][j] <= C && ab[1][j] >= C)
                        result[i]++;
                }
            }
            
            System.out.print("#" + test_case);
            for(int i = 0; i < P; i++)
                System.out.print(" " + result[i]);
            System.out.println();
		}
	}
}
