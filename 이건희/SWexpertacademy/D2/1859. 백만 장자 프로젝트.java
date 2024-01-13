import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            int[] nums = new int[N];
            Long result = 0l;
            int cnt = 0;
            
            for (int i = N - 1; 0 <= i; i--) {
                nums[i] = sc.nextInt();
            }
            
            for (int num : nums) {
                if (num > cnt) {
                    cnt = num;
                } else {
                    result += cnt - num;
                }
            }
            
            System.out.println("#" + test_case + " " + result);
		}
	}
}
