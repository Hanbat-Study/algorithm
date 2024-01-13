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
            int[][] arr = new int[N][N];
            int[][][] result = new int[N][3][N];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            
            for (int i = 0; i < N; i++) {
                int[] box = new int[N];
                
                for (int j = N - 1; 0 <= j; j--) {
                    box[N - j - 1] = arr[j][i];
                }
                result[i][0] = box;
            }
            
            for (int i = N - 1; 0 <= i; i--) {
                int[] box = new int[N];
                
                for (int j = N - 1; 0 <= j; j--) {
                    box[N - j - 1] = arr[i][j];
                }
                result[N - i - 1][1] = box;
            }
            
            for (int i = N - 1; 0 <= i; i--) {
                int[] box = new int[N];
                
                for (int j = 0; j < N; j++) {
                    box[j] = arr[j][i];
                }
                result[N - i - 1][2] = box;
            }
            
            System.out.printf("#%d\n", test_case);
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < N; k++) {
                        System.out.print(result[i][j][k]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
		}
	}
}
