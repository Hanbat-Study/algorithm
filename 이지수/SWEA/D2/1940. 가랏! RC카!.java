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
            int v = 0;
            int d = 0;
            for(int i = 0; i < N; i++){
            	int command = sc.nextInt();
                if(command == 0)
                    d += v;
                else if(command == 1) {
                    v += sc.nextInt();
                	d += v;
                }
                else {
                    int a = sc.nextInt();
                	v = (v - a >= 0? v - a : 0);
                    d += v;
                }
            }
            System.out.println("#" + test_case + " " + d);
		}
	}
}
