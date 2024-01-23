import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = 10;
		
		for(int i = 0; i < testCase; i++) {
			br.readLine();
			String[][] board = new String[100][100];
			int result = 0;
			
			for(int j = 0; j < 100; j++)
                board[j] = br.readLine().split(" ");
            
			for(int c = 0; c < 100; c++) {
				int dir = 0;
				for(int r = 0; r < 100; r++) {
					String s = board[r][c];
					if(s.equals("1"))
						dir = 1;
					else if(s.equals("2") && dir == 1) {
						result++;
						dir = 0;
					}
						
				}
			}
			
			System.out.println("#" + (i + 1) + " " + result);			
		}
	}
}
