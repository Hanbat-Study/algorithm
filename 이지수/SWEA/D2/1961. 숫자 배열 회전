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
            int[][] arr = new int[N][N];
            char[][] result90 = new char[N][N];
            char[][] result180 = new char[N][N];
            char[][] result270 = new char[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                	arr[i][j] = sc.nextInt();
                    result90[j][N - i - 1] = (char)(arr[i][j] + '0');
                    result180[N - i - 1][N - j - 1] = (char)(arr[i][j] + '0');
                    result270[N - j - 1][i] = (char)(arr[i][j] + '0');
                }
            }
            
            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++) {
                System.out.println(String.valueOf(result90[i]) + " " + String.valueOf(result180[i]) + " " + String.valueOf(result270[i]));
            }
		}
	}
}
