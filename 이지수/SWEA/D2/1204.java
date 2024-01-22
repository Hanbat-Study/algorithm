import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            sc.nextInt();
            
            int[] scores = new int[101];
            for(int i = 0; i < 1000; i++){
            	scores[sc.nextInt()]++;
            }
            
            int[] result = {-1, 0};
            for(int i = 0; i < 101; i++) {
            	if(scores[i] > result[1] || (scores[i] == result[1] && i > result[0])) {
                    result[0] = i;
                    result[1] = scores[i];
                }
            }
            System.out.println("#" + test_case + " " + result[0]);
		}
	}
}
