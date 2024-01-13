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
            int result = 0;
            int speed = 0;
            int N = sc.nextInt();
            
            for (int i = 0; i < N; i++) {
                int command = sc.nextInt();
                
                if (command == 1) {
                    speed += sc.nextInt();
                } else if (command == 2) {
                    speed -= sc.nextInt();
                    speed = (speed > 0) ? speed : 0;
                }
                result += speed;
            }
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}
