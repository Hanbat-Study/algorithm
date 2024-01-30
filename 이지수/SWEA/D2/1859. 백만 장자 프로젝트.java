import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] prices = new int[N];
			for(int i = 0; i < N; i++) {
				prices[i] = sc.nextInt();
			}
			
			int result = 0;
			int idx = -1;
			while(idx < N) {
				int max = -1;
				for(int i = idx + 1; i < prices.length; i++) {
					if(prices[i] >= max) {
						max = prices[i];
						idx = i;
					}
				}
				for(int i = 0; i < idx; i++) {
					result += max - prices[i];
				}
			}
            System.out.println("#" + test_case + " " + result);
		}
	}
}
